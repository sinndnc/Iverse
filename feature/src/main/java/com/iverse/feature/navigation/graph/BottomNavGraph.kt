package com.iverse.feature.navigation.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iverse.feature.navigation.content.BottomScreens
import com.iverse.feature.presentation.main.pages.chat.ChatUI
import com.iverse.feature.presentation.main.pages.chat.ChatViewModel
import com.iverse.feature.presentation.main.pages.home.HomeUI
import com.iverse.feature.presentation.main.pages.home.HomeViewModel
import com.iverse.feature.presentation.main.pages.notification.NotificationUI
import com.iverse.feature.presentation.main.pages.search.SearchUI

@Composable
fun ColumnScope.BottomNavGraph(navController: NavHostController) {

    Box(modifier = Modifier.weight(0.92f)) {
        NavHost(
            navController = navController,
            startDestination = BottomScreens.HOME.route,
        ) {
            composable(route = BottomScreens.HOME.route) {
                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeUI(viewModel = homeViewModel)
            }
            composable(route = BottomScreens.SEARCH.route) {
                SearchUI()
            }
            composable(route = BottomScreens.NOTIFICATIONS.route) {
                NotificationUI()
            }
            composable(route = BottomScreens.CHAT.route) {
                val messageViewModel = hiltViewModel<ChatViewModel>()
                ChatUI(viewModel = messageViewModel)
            }
        }
    }
}