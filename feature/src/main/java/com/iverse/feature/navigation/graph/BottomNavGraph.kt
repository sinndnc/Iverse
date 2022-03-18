package com.iverse.feature.navigation.graph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.iverse.core.utils.navigation.BottomNavigationDispatcher
import com.iverse.core.utils.navigation.NavigationDispatcher
import com.iverse.feature.navigation.content.BottomPages
import com.iverse.feature.presentation.main.MainViewModel
import com.iverse.feature.presentation.main.pages.home.HomeUI
import com.iverse.feature.presentation.main.pages.home.HomeViewModel
import com.iverse.feature.presentation.main.pages.chat.MessageUI
import com.iverse.feature.presentation.main.pages.chat.ChatViewModel
import com.iverse.feature.presentation.main.pages.notification.NotificationUI
import com.iverse.feature.presentation.main.pages.search.SearchUI

@Composable
fun ColumnScope.BottomNavGraph(
    navController: NavHostController,
    bottomNavigationDispatcher : BottomNavigationDispatcher,
    lifecycleOwner : LifecycleOwner,
) {
    val mainViewModel = hiltViewModel<MainViewModel>()

    Box(modifier = Modifier.weight(0.92F)) {
        NavHost(
            navController = navController,
            startDestination = BottomPages.HOME.route
        ) {
            composable(route = BottomPages.HOME.route) {
                val homeViewModel = hiltViewModel<HomeViewModel>()
                HomeUI(viewModel = homeViewModel, mainViewModel = mainViewModel)
            }
            composable(route = BottomPages.SEARCH.route) {
                SearchUI()
            }
            composable(route = BottomPages.NOTIFICATIONS.route) {
                NotificationUI()
            }
            composable(route = BottomPages.MESSAGES.route) {
                val messageViewModel = hiltViewModel<ChatViewModel>()
                MessageUI(viewModel = messageViewModel)
            }
            bottomNavigationDispatcher.navigationEmitter.observe(lifecycleOwner) { navigationCommand ->
                navigationCommand.invoke(navController)
            }
        }
    }
}