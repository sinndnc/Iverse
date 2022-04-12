package com.iverse.feature.navigation.content

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.iverse.feature.R

sealed class BottomScreens(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {
    object HOME : BottomScreens("bottom_home", R.string.home_text, R.drawable.home_logo)
    object SEARCH : BottomScreens("bottom_search", R.string.search_text, R.drawable.search_logo)
    object NOTIFICATIONS : BottomScreens("bottom_notifications", R.string.notification_text, R.drawable.notifications_logo)
    object CHAT : BottomScreens("bottom_messages", R.string.message_text, R.drawable.chat_logo)
}
