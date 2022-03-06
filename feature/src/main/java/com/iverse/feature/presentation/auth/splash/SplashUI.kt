package com.iverse.feature.presentation.auth.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startForegroundService
import androidx.navigation.NavController
import com.iverse.core.constant.AuthPreferencesKeys
import com.iverse.core.data.local.storage.StorageManagerImpl
import com.iverse.core.data.local.storage.dataStore
import com.iverse.feature.navigation.Screens
import kotlinx.coroutines.flow.map

@Composable
fun SplashUI(navController: NavController) {
    val context = LocalContext.current
    val token = StorageManagerImpl(context).readBooleanData(AuthPreferencesKeys.ISTOKEN).collectAsState(initial = false)

    Box(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)) {
        LaunchedEffect(Unit) {
            navController.navigate(if (token.value == true) Screens.MainUI.route else Screens.OnBoardUI.route)
            { popUpTo(Screens.SplashUI.route) { inclusive = true } }
        }
    }

}