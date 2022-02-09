package com.iverse.feature.presentation.main.pages.notification

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.component.view.Container

@Composable
fun NotificationUI(){
    Container(isProcess = false, isHasInternet = NetworkState.CONNECTED) {
        Text(text = "NOTIFICATION UI")
    }
}