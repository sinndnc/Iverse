package com.iverse.feature.component.popUp

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.R
import com.iverse.feature.component.text.OverlineText
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Green

@Composable
fun ReConnectionPopUp(modifier: Modifier = Modifier, isHasInternet: NetworkState) {

    AnimatedVisibility(
        modifier = modifier,
        visible = isHasInternet == NetworkState.RECONNECTED,
        enter = slideIn(
            animationSpec = tween(durationMillis = 500),
            initialOffset = { IntOffset(0, (it.height / 0.1F).toInt()) }),
        exit = slideOut(
            animationSpec = tween(durationMillis = 500),
            targetOffset = { IntOffset(0, (it.height / 0.1F).toInt()) })
    ) {
        Box(
            modifier = Modifier.background(Green.p500, CustomSmallShapes.small)
                .fillMaxWidth().fillMaxHeight(0.035F),
            contentAlignment = Alignment.Center
        ) {
            OverlineText(R.string.reconnection_text, fontSize = 14.sp, textColor = Color.White)
        }
    }
}