package com.iverse.feature.presentation.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.iverse.feature.extensions.noRippleClickable
import com.iverse.feature.presentation.auth.login.views.LoginBodyView
import com.iverse.feature.presentation.auth.login.views.LoginBottomView
import com.iverse.feature.presentation.auth.login.views.LoginHeaderView


@Composable
fun LoginUI(
    navController: NavController,
    loginViewModel: LoginViewModel,
    screenHeight: Dp,
    screenWidth: Dp,
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .noRippleClickable {
                focusManager.clearFocus()
            }
            .padding(horizontal = screenWidth * 0.08F, vertical = screenWidth * 0.03F),
        verticalArrangement = Arrangement.Center,
    ) {
        LoginHeaderView(modifier = Modifier.weight(1.2F, true), navController, focusManager)
        LoginBodyView(modifier = Modifier.weight(2F, true), navController, loginViewModel)
        LoginBottomView(Modifier.fillMaxSize().weight(2F, true), navController, loginViewModel)
    }
}
