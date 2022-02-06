package com.iverse.feature.presentation.auth.onboard

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iverse.feature.component.view.Container
import com.iverse.feature.navigation.Screens

//TODO EDIT THIS CLASS
@Composable
fun OnBoardUI(navController: NavController, viewModel: OnBoardViewModel) {

    val isProcess = viewModel.isPopUp.value || viewModel.isLoading.value
    val isHasInternet = viewModel.isNetwork.value

    Container(isProcess = isProcess, isHasInternet = isHasInternet) {
        Button(onClick = {
            navController.navigate(Screens.LoginUI.route)
        }) {
            Text("Sign with email")
        }
    }
}