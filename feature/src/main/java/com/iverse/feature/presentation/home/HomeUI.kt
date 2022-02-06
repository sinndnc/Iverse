package com.iverse.feature.presentation.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.iverse.feature.component.view.Container

@Composable
fun HomeUI(navController: NavController, viewModel: HomeViewModel) {

    val isProcess = viewModel.isLoading.value || viewModel.isPopUp.value
    val isHasInternet = viewModel.isNetwork.value

    Container(isProcess = isProcess, isHasInternet = isHasInternet) {
        Text(text = "HOME UI")
    }
}