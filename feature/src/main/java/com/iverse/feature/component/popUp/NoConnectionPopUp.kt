package com.iverse.feature.component.popUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun NoConnectionPopUp(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Red)
            .fillMaxWidth().fillMaxHeight(0.1F).padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text("No internet connection")
    }
}