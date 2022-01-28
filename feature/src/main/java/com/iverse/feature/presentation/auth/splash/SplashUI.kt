package com.iverse.feature.presentation.auth.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import com.iverse.feature.navigation.Screens

@Composable
fun SplashUI(navController: NavController) {
    LaunchedEffect(Unit) {
        navController.navigate(Screens.LoginUI.route) {
            popUpTo(Screens.SplashUI.route) { inclusive = true }
        }
    }
}