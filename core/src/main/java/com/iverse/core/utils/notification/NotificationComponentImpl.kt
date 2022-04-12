package com.iverse.core.utils.notification

import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.iverse.core.R
import com.iverse.core.constant.NotificationConstant
import com.iverse.core.domain.model.NotificationModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationComponentImpl @Inject constructor(
    @ApplicationContext private val context: Context,
) : NotificationComponent {


    override val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    override fun buildDefaultNotification(notificationModel: NotificationModel) {
        //TODO("Not yet implemented")
        val builder = NotificationCompat.Builder(context, NotificationConstant.ID.GROUP_CHATS_NOTIFICATION_CHANNEL)
            .setSmallIcon(R.drawable.gcm_icon)
            .setContentTitle(notificationModel.title)
            .setContentText(notificationModel.body)
            .setSubText("info")
        notificationManager.notify(0, builder.build())
    }


    override fun buildExpandableNotification(notificationModel: NotificationModel) {
        //TODO("Not yet implemented")
    }

    override fun buildGroupNotification(notificationModel: NotificationModel) {
        TODO("Not yet implemented")
    }

    override fun buildActionableNotification(notificationModel: NotificationModel) {
        TODO("Not yet implemented")
    }


}