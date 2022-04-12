package com.iverse.core.utils.service.notification


import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.iverse.core.R
import com.iverse.core.constant.NotificationConstant
import com.iverse.core.domain.model.ChatType
import com.iverse.core.domain.model.NotificationModel
import com.iverse.core.domain.repository.user.UserRepository
import com.iverse.core.utils.qualifiers.NOTIFICATION
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


const val TAG = "FCMToken"


@AndroidEntryPoint
class NotificationService : FirebaseMessagingService() {

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    @NOTIFICATION
    lateinit var intent: Intent

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        runBlocking(Dispatchers.Default) {
            userRepository.updateCurrentUserToken(token).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "received a new token : $token")
                    //TODO(developer)
                } else {

                }
            }
        }
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val data = remoteMessage.data

        if (data.isNotEmpty()) {
            val model = data.castToModel()
            when (data.getChatType()) {
                ChatType.Private -> {
                    buildNotification(model.title, model.body, "private chat")
                }
                ChatType.Group -> {
                    buildNotification(model.title, model.body, "group chat")
                }
            }
        }
    }


    private fun buildNotification(title: String, body: String, info: String) {

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val builder = NotificationCompat.Builder(this, NotificationConstant.ID.GROUP_CHATS_NOTIFICATION_CHANNEL)
            .setSmallIcon(R.drawable.gcm_icon)
            .setContentTitle(title)
            .setSubText(info)
            .setContentText(body)
        notificationManager.notify(0, builder.build())
    }


    private fun Map<String, String>.getChatType(): ChatType {
        return ChatType.valueOf(this["groupType"]!!)
    }

    private fun Map<String, String>.castToModel(): NotificationModel =
        NotificationModel(this["title"]!!, this["body"]!!)

}



