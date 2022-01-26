package com.iverse.feature.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iverse.feature.presentation.auth.LoginViewModel
import com.iverse.feature.screens.auth.login.LoginUI
import com.iverse.feature.screens.auth.SplashUI


@Composable
fun IverseNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.SplashUI.route) {
        composable(Screens.SplashUI.route) {
            SplashUI(navController = navController)
        }
        composable(Screens.LoginUI.route) {
            val loginViewModel = hiltViewModel<LoginViewModel>()
            LoginUI(navController = navController, loginViewModel = loginViewModel)
        }
    }
}