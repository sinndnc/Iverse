package com.iverse.feature.presentation.main.pages.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.component.view.Container


@Composable
fun HomeUI() {
    Container(isProcess = false, isHasInternet = NetworkState.CONNECTED) {
        Text(text = "HOME UI")
    }
}