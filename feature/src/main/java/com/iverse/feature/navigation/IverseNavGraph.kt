package com.iverse.feature.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iverse.feature.presentation.auth.login.LoginViewModel
import com.iverse.feature.presentation.auth.login.LoginUI
import com.iverse.feature.presentation.auth.splash.SplashUI


@Composable
fun IverseNavGraph() {
    val navController = rememberNavController()
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    NavHost(navController = navController, startDestination = Screens.SplashUI.route) {
        composable(Screens.SplashUI.route) {
            SplashUI(navController = navController)
        }
        composable(Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(navController = navController, loginViewModel = loginViewModel, screenHeight, screenWidth)
        }
    }
}