package com.iverse.core.utils.notification

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import com.iverse.core.constant.NotificationConstant
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationHelperImpl @Inject constructor(
    @ApplicationContext context: Context
) : NotificationHelper {

    override val notificationManager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


    /**
     * Create a new single Channel for [groupId] category also if you want to specific category can you pass that value
     * [channelId] is specific string value,[channelName] is showing label on settings, [channelDescription] is showing text
     * under the label about to channel's job
     */
    override fun createNotificationChannelIfNotExists(
        channelId: String,
        channelName: String,
        channelDescription: String,
        groupId: String
    ) {
        if (notificationManager.getNotificationChannel(channelId) == null) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            channel.description = channelDescription
            channel.group = groupId
            notificationManager.createNotificationChannel(channel)
        }
    }


    /**
     * Create a new group Channel [groupName] is showing label on settings ,[groupId] is specific string value,
     * [groupDescription] is maybe return null cause required a [Build.VERSION.SDK_INT] >= [Build.VERSION_CODES.P] SDK version
     */
    override fun createNotificationChannelGroupIfNotExists(groupId: String, groupName: String, groupDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (notificationManager.getNotificationChannelGroup(groupId) == null) {
                val groupChannel = NotificationChannelGroup(groupId, groupName)
                groupChannel.description = groupDescription
                notificationManager.createNotificationChannelGroup(groupChannel)
            }
        }
    }


    /**
     * Create a new notification channel for [NotificationConstant.GROUP.CHATS_NOTIFICATION_CHANNEL] category
     */
    override fun createChatNotificationChannel() {
        val chatChannelId = NotificationConstant.ID.CHATS_NOTIFICATION_CHANNEL
        val chatChannelName = NotificationConstant.GROUP.CHATS_NOTIFICATION_CHANNEL
        val chatChannelDescription = NotificationConstant.DESCRIPTION.CHATS_NOTIFICATION_CHANNEL

        val privateChannelId = NotificationConstant.ID.PRIVATE_CHATS_NOTIFICATION_CHANNEL
        val privateChannelName = NotificationConstant.CHANNEL.PRIVATE_CHATS_NOTIFICATION_CHANNEL
        val privateChannelDescription = NotificationConstant.DESCRIPTION.PRIVATE_CHATS_NOTIFICATION_CHANNEL

        val groupChannelId = NotificationConstant.ID.GROUP_CHATS_NOTIFICATION_CHANNEL
        val groupChannelName = NotificationConstant.CHANNEL.GROUP_CHATS_NOTIFICATION_CHANNEL
        val groupChannelDescription = NotificationConstant.DESCRIPTION.GROUP_CHATS_NOTIFICATION_CHANNEL

        createNotificationChannelGroupIfNotExists(chatChannelId, chatChannelName, chatChannelDescription)
        createNotificationChannelIfNotExists(groupChannelId, groupChannelName, groupChannelDescription, chatChannelId)
        createNotificationChannelIfNotExists(privateChannelId, privateChannelName, privateChannelDescription, chatChannelId)
    }


}