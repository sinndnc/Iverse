package com.iverse.feature.presentation.auth.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier


@Composable
fun SplashUI(viewModel: SplashViewModel) {
    val isUser = viewModel.firebaseAuth.currentUser
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        LaunchedEffect(Unit) {
            if (isUser != null) viewModel.redirectToMain() else viewModel.redirectToOnBoard()
        }
    }
}