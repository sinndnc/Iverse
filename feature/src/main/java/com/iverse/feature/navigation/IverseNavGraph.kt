package com.iverse.feature.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iverse.feature.presentation.auth.login.LoginViewModel
import com.iverse.feature.presentation.auth.login.LoginUI
import com.iverse.feature.presentation.auth.onboard.OnBoardUI
import com.iverse.feature.presentation.auth.onboard.OnBoardViewModel
import com.iverse.feature.presentation.auth.splash.SplashUI
import com.iverse.feature.presentation.main.MainUI


@Composable
fun IverseNavGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashUI.route) {
        composable(Screens.SplashUI.route) {
            SplashUI(navController = navController)
        }
        composable(Screens.OnBoardUI.route) {
            val onBoardViewModel = hiltViewModel<OnBoardViewModel>()
            OnBoardUI(navController = navController, viewModel = onBoardViewModel)
        }
        composable(Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(navController = navController, viewModel = loginViewModel)
        }
        composable(Screens.HomeUI.route) { MainUI() }
    }
}