package com.iverse.core.constant

object NotificationConstant {

    object ID {
        const val DEFAULT_NOTIFICATION_CHANNEL = "IVERSE_NOTIFICATION_CHANNEL"

        //***************** CHATS CATEGORY ******************
        const val CHATS_NOTIFICATION_CHANNEL = "IVERSE_CHATS_CHANNEL"
        const val GROUP_CHATS_NOTIFICATION_CHANNEL = "IVERSE_GROUP_CHATS_NOTIFICATION_CHANNEL"
        const val PRIVATE_CHATS_NOTIFICATION_CHANNEL = "IVERSE_PRIVATE_CHATS_NOTIFICATION_CHANNEL"

        //***************** FEED CATEGORY *******************
        const val FEED_NOTIFICATION_CHANNEL = "IVERSE_FEED_CHANNEL"
        const val STORY_NOTIFICATION_CHANNEL = "IVERSE_STORY_CHANNEL"

    }

    object GROUP {
        const val CHATS_NOTIFICATION_CHANNEL = "Chat"
        const val FEED_NOTIFICATION_CHANNEL = "Feed"
    }

    object CHANNEL {
        //***************** CHATS CATEGORY ******************
        const val GROUP_CHATS_NOTIFICATION_CHANNEL = "Group Notifications"
        const val PRIVATE_CHATS_NOTIFICATION_CHANNEL = "Private Notifications"

        //***************** FEED CATEGORY *******************
        const val STORY_NOTIFICATION_CHANNEL = "Story Notifications"
    }

    object DESCRIPTION {
        //***************** CHATS CATEGORY ******************
        const val CHATS_NOTIFICATION_CHANNEL = "Chats channel description"
        const val GROUP_CHATS_NOTIFICATION_CHANNEL = "Group channel description"
        const val PRIVATE_CHATS_NOTIFICATION_CHANNEL = "Private channel description"

        //***************** FEED CATEGORY *******************
        const val FEED_NOTIFICATION_CHANNEL = "Feeds channel description"
    }
}