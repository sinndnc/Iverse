package com.iverse.feature.component.popUp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.Green

@Composable
fun ReConnectionPopUp(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Green.p500)
            .fillMaxWidth().fillMaxHeight(0.1F).padding(10.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Text("Welcome back Again")
    }
}