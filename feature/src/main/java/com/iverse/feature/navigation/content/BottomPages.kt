package com.iverse.feature.navigation.content

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.iverse.feature.R

sealed class BottomPages(
    val route: String,
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
) {


    object HOME : BottomPages("home", R.string.home_text, R.drawable.home_logo)
    object SEARCH : BottomPages("search", R.string.search_text, R.drawable.search_logo)
    object NOTIFICATIONS : BottomPages("notifications", R.string.notification_text, R.drawable.notifications_logo)
    object MESSAGES : BottomPages("messages", R.string.message_text, R.drawable.chat_logo)


}
