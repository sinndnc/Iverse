package com.iverse.feature.navigation.graph

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iverse.core.constant.FirestoreConstants
import com.iverse.core.utils.navigation.*
import com.iverse.feature.navigation.AUTH_GRAPH_ROUTE
import com.iverse.feature.navigation.Screens
import com.iverse.feature.presentation.main.MainViewModel
import com.iverse.feature.presentation.main.pages.MainUI
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomUI
import com.iverse.feature.presentation.main.pages.chat.chat_room.ChatRoomViewModel


@Composable
fun IverseNavGraph(
    navigationDispatcher: NavigationDispatcher,
    lifecycleOwner: LifecycleOwner,
) {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .systemBarsPadding(),
        navController = navController,
        startDestination = AUTH_GRAPH_ROUTE,
    ) {
        authNavGraph()
        composable(route = Screens.MainUI.route) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainUI(viewModel = mainViewModel)
        }
        composable(
            route = Screens.ChatRoomUI.route + "/{chatUid}",
            arguments = listOf(navArgument(FirestoreConstants.CHAT_ROOM_CHAT_UID) {
                type = NavType.StringType
                nullable = false
            })
        ) { navBackStackEntry ->
            val chatRoomViewModel = hiltViewModel<ChatRoomViewModel>()
            val chatUid = navBackStackEntry.arguments?.getString(FirestoreConstants.CHAT_ROOM_CHAT_UID)!!
            ChatRoomUI(viewModel = chatRoomViewModel, chatUid = chatUid)
        }
        navigationDispatcher.navigationEmitter.observe(lifecycleOwner) { navigationCommand ->
            navigationCommand.invoke(navController)
        }

    }
}