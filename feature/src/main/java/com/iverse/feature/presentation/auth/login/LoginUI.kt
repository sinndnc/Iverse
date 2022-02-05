package com.iverse.feature.presentation.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.component.view.Container
import com.iverse.feature.extensions.noRippleClickable
import com.iverse.feature.presentation.auth.login.views.LoginBodyView
import com.iverse.feature.presentation.auth.login.views.LoginBottomView
import com.iverse.feature.presentation.auth.login.views.LoginHeaderView


//EDIT THIS CLASS
@Composable
fun LoginUI(
    navController: NavController,
    loginViewModel: LoginViewModel,
    screenHeight: Dp,
    screenWidth: Dp,
) {
    val focusManager = LocalFocusManager.current

    Container(isProcess = false, isHasInternet = NetworkState.CONNECTED) {
        Column(
            modifier = Modifier.fillMaxSize().noRippleClickable { focusManager.clearFocus() }
                .padding(horizontal = screenWidth * 0.07F, vertical = screenHeight * 0.02F)
                .alpha(if (false) 0.2F else 1F),
            verticalArrangement = Arrangement.Center,
        ) {
            LoginHeaderView(modifier = Modifier.weight(1.2F, true), focusManager)
            LoginBodyView(modifier = Modifier.weight(2F, true),loginViewModel)
            LoginBottomView(Modifier.fillMaxSize().weight(2F, true),loginViewModel)
        }
    }

}
