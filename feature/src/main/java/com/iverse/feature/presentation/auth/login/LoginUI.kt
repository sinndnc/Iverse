package com.iverse.feature.presentation.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iverse.feature.component.view.Container
import com.iverse.feature.extensions.noRippleClickable
import com.iverse.feature.presentation.auth.login.components.LoginBodyView
import com.iverse.feature.presentation.auth.login.components.LoginBottomView
import com.iverse.feature.presentation.auth.login.components.LoginHeaderView


//TODO EDIT THIS CLASS
@Composable
fun LoginUI(
    navController: NavController,
    viewModel: LoginViewModel,
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp
    val focusManager = LocalFocusManager.current
    val isHasInternet = viewModel.isNetwork.value
    val isProcess = viewModel.isLoading.value || viewModel.isPopUp.value

    Container(isProcess = isProcess, isHasInternet = isHasInternet) {
        Column(
            modifier = Modifier.fillMaxSize().noRippleClickable { focusManager.clearFocus() }
                .padding(horizontal = screenWidth * 0.07F, vertical = screenHeight * 0.02F)
                .alpha(if (isProcess) 0.2F else 1F),
            verticalArrangement = Arrangement.Center,
        ) {
            LoginHeaderView(modifier = Modifier.weight(1.2F, true), focusManager)
            LoginBodyView(modifier = Modifier.weight(2F, true), viewModel, navController)
            LoginBottomView(Modifier.fillMaxSize().weight(2F, true), viewModel)
        }
    }

}
