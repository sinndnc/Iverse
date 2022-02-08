package com.iverse.feature.presentation.home.views

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.iverse.feature.R

sealed class Pages(val route: String, @StringRes title: Int, @DrawableRes val icon: Int) {

    object HOME : Pages("home", R.string.home_text, R.drawable.home_logo)
    object SEARCH : Pages("home", R.string.search_text, R.drawable.search_logo)
    object NOTIFICATIONS : Pages("home", R.string.notification_text, R.drawable.notifications_logo)
    object MESSAGES : Pages("home", R.string.message_text, R.drawable.chat_logo)
}
