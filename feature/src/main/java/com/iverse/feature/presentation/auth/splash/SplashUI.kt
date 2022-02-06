package com.iverse.feature.presentation.auth.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.StorageManagerImpl
import com.iverse.feature.navigation.Screens

@Composable
fun SplashUI(navController: NavController) {
    val token = StorageManagerImpl(LocalContext.current)
        .readBooleanData(AuthPreferencesKeys.ISTOKEN)
        .collectAsState(initial = false)

    LaunchedEffect(Unit) {
        navController.navigate(
            if (token.value == true)
                Screens.HomeUI.route else Screens.OnBoardUI.route
        )
        {
            popUpTo(Screens.SplashUI.route) { inclusive = true }
        }
    }
}