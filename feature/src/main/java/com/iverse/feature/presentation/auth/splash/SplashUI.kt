package com.iverse.feature.presentation.auth.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManager
import com.iverse.core.data.local.storage.StorageManagerImpl
import com.iverse.feature.navigation.Screens
import kotlinx.coroutines.launch

@Composable
fun SplashUI(navController: NavController) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val token = StorageManagerImpl(context).readBooleanData(AuthPreferencesKeys.ISTOKEN)

        navController.navigate(if (token == true) Screens.HomeUI.route else Screens.OnBoardUI.route)
        { popUpTo(Screens.SplashUI.route) { inclusive = true } }
    }
}