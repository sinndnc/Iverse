package com.iverse.feature.component.popUp

import android.os.CountDownTimer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.iverse.core.utils.connectivity.NetworkState


@Composable
fun NoConnectionPopUp(modifier: Modifier = Modifier, isHasInternet: NetworkState) {

    AnimatedVisibility(
        modifier = modifier,
        visible = isHasInternet == NetworkState.UNCONNECTED,
        enter = slideIn(
            animationSpec = tween(durationMillis = 500),
            initialOffset = { IntOffset(0, (it.height / 0.1F).toInt()) }),
        exit = slideOut(
            animationSpec = tween(durationMillis = 500),
            targetOffset = { IntOffset(0, (it.height / 0.1F).toInt()) })
    ) {
        Box(
            modifier = Modifier.background(Color.Red)
                .fillMaxWidth().fillMaxHeight(0.1F).padding(10.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Text("No internet connection")
        }
    }
}