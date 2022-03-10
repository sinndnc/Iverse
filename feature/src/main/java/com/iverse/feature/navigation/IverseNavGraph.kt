package com.iverse.feature.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iverse.feature.presentation.auth.login.LoginUI
import com.iverse.feature.presentation.auth.login.LoginViewModel
import com.iverse.feature.presentation.auth.onboard.OnBoardUI
import com.iverse.feature.presentation.auth.onboard.OnBoardViewModel
import com.iverse.feature.presentation.auth.splash.SplashUI
import com.iverse.feature.presentation.auth.splash.SplashViewModel
import com.iverse.feature.presentation.main.MainUI
import com.iverse.feature.presentation.main.pages.message.chat.ChatUI
import com.iverse.feature.presentation.main.pages.message.chat.ChatViewModel


@Composable
fun IverseNavGraph() {

    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
            .systemBarsPadding(),
        navController = navController,
        startDestination = Screens.SplashUI.route
    ) {
        composable(Screens.SplashUI.route) {
            val splashViewModel = hiltViewModel<SplashViewModel>()
            SplashUI(navController = navController,viewModel = splashViewModel)
        }
        composable(Screens.OnBoardUI.route) {
            val onBoardViewModel = hiltViewModel<OnBoardViewModel>()
            OnBoardUI(navController = navController, viewModel = onBoardViewModel)
        }
        composable(Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(navController = navController, viewModel = loginViewModel)
        }
        composable(Screens.MainUI.route) {
            MainUI(mainNavController = navController)
        }
        composable(
            route = "${Screens.ChatUI.route}/{userImage}/{userName}",
            arguments = listOf(
                navArgument("userImage") { type = NavType.StringType },
                navArgument("userName") { type = NavType.StringType },
                )
        ) { backStackEntry ->
            val chatViewModel = hiltViewModel<ChatViewModel>()
            val image = backStackEntry.arguments?.getString("userImage")
            val name = backStackEntry.arguments?.getString("userName")
            ChatUI(navController = navController, viewModel = chatViewModel, image = image!!,name = name!!)
        }
    }
}