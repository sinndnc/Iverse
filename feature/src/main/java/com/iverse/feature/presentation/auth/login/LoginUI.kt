package com.iverse.feature.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iverse.feature.component.popUp.NoConnectionPopUp
import com.iverse.feature.component.popUp.ReConnectionPopUp
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.feature.component.view.Container
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

    Container {
        Column(
            modifier = Modifier.fillMaxSize().noRippleClickable { focusManager.clearFocus() }
                .padding(horizontal = screenWidth * 0.08F, vertical = screenHeight * 0.02F)
                .alpha(if (loginViewModel.isLoading.value) 0.2F else 1F),
            verticalArrangement = Arrangement.Center,
        ) {
            LoginHeaderView(modifier = Modifier.weight(1.2F, true), navController, focusManager)
            LoginBodyView(modifier = Modifier.weight(2F, true), navController, loginViewModel)
            LoginBottomView(Modifier.fillMaxSize().weight(2F, true), navController, loginViewModel)
        }
        //TODO PROGRESS BAR
        if (loginViewModel.isLoading.value) {
            Surface(
                color = Gray.p800,
                shape = CustomSmallShapes.large,
                elevation = 50.dp,
            ) {
                CircularProgressIndicator(modifier = Modifier.padding(all = 25.dp), color = Color.White)
            }
        }
        ReConnectionPopUp(modifier = Modifier.align(Alignment.BottomCenter))
    }

}
