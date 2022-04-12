package com.iverse.feature.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.iverse.feature.navigation.AUTH_GRAPH_ROUTE
import com.iverse.feature.navigation.Screens
import com.iverse.feature.presentation.auth.login.LoginUI
import com.iverse.feature.presentation.auth.login.LoginViewModel
import com.iverse.feature.presentation.auth.onboard.OnBoardUI
import com.iverse.feature.presentation.auth.onboard.OnBoardViewModel
import com.iverse.feature.presentation.auth.splash.SplashUI
import com.iverse.feature.presentation.auth.splash.SplashViewModel

fun NavGraphBuilder.authNavGraph() {
    navigation(
        startDestination = Screens.SplashUI.route,
        route = AUTH_GRAPH_ROUTE
    ){
        composable(Screens.SplashUI.route) {
            val splashViewModel = hiltViewModel<SplashViewModel>()
            SplashUI(viewModel = splashViewModel)
        }
        composable(Screens.OnBoardUI.route) {
            val onBoardViewModel = hiltViewModel<OnBoardViewModel>()
            OnBoardUI(viewModel = onBoardViewModel)
        }
        composable(Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(viewModel = loginViewModel)
        }
    }

}