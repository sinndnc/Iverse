package com.iverse.feature.presentation.main.pages.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.component.view.Container
import com.iverse.feature.presentation.main.MainViewModel


@Composable
fun HomeUI(viewModel: HomeViewModel) {
    Container(isProcess = false, isHasInternet = NetworkState.CONNECTED) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { viewModel.changeToDarkTheme() }) {
                Text(text = "change to Dark theme")
            }
            Button(enabled = true, onClick = { viewModel.changeToLightTheme() }) {
                Text(text = "change to Light theme")
            }
        }

    }
}