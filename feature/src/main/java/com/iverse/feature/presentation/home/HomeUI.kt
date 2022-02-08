package com.iverse.feature.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iverse.feature.presentation.home.views.Pages
import com.iverse.feature.component.view.Container
import com.iverse.feature.presentation.home.views.BottomBarView

@Composable
fun HomeUI(navController: NavController, viewModel: HomeViewModel) {

    val isProcess = viewModel.isLoading.value || viewModel.isPopUp.value
    val isHasInternet = viewModel.isNetwork.value
    var currentRoute by remember { mutableStateOf(Pages.HOME.route) }


    Column(modifier = Modifier.fillMaxSize()) {
        Container(modifier = Modifier.weight(12F), isProcess = isProcess, isHasInternet = isHasInternet) {
            Text("HOME UI")
        }
        BottomBarView(
            selectedRoute = currentRoute,
            onItemSelected = {
                currentRoute = it.route
            }
        )
    }

}