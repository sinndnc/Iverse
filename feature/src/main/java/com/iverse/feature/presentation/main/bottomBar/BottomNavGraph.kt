package com.iverse.feature.presentation.main.bottomBar

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iverse.feature.presentation.main.pages.home.HomeUI
import com.iverse.feature.presentation.main.pages.message.MessageUI
import com.iverse.feature.presentation.main.pages.notification.NotificationUI
import com.iverse.feature.presentation.main.pages.search.SearchUI

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.93F),
        navController = navController,
        startDestination = BottomPages.HOME.route
    ) {
        composable(route = BottomPages.HOME.route) {
            HomeUI()
        }
        composable(route = BottomPages.SEARCH.route) {
            SearchUI()
        }
        composable(route = BottomPages.NOTIFICATIONS.route) {
            NotificationUI()
        }
        composable(route = BottomPages.MESSAGES.route) {
            MessageUI()
        }
    }
}