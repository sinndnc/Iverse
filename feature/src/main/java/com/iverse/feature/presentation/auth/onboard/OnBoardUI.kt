package com.iverse.feature.presentation.auth.onboard

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.iverse.feature.component.view.Container

//TODO EDIT THIS CLASS
@Composable
fun OnBoardUI(viewModel: OnBoardViewModel) {

    val isProcess = viewModel.isPopUp.value || viewModel.isLoading.value
    val isHasInternet = viewModel.isNetwork.value

    Container(isProcess = isProcess, isHasInternet = isHasInternet) {
        Button(onClick = {}) {
            Text("Sign with email")
        }
    }
}