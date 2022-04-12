package com.iverse.core.utils.notification

import android.app.NotificationManager

interface NotificationHelper {

    val notificationManager: NotificationManager

    fun createNotificationChannelIfNotExists(channelId: String, channelName: String, channelDescription: String, groupId: String)

    fun createNotificationChannelGroupIfNotExists(groupId: String, groupName: String, groupDescription: String)

    fun createChatNotificationChannel()
}