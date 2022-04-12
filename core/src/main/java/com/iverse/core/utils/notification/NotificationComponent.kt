package com.iverse.core.utils.notification

import android.app.NotificationManager
import com.iverse.core.domain.model.NotificationModel


interface NotificationComponent {

    val notificationManager: NotificationManager

    fun buildDefaultNotification(notificationModel: NotificationModel)

    fun buildExpandableNotification(notificationModel: NotificationModel)

    fun buildGroupNotification(notificationModel: NotificationModel)

    fun buildActionableNotification(notificationModel: NotificationModel)

}