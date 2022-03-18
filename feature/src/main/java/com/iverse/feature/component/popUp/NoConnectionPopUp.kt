package com.iverse.feature.component.popUp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.sp
import com.iverse.core.utils.connectivity.NetworkState
import com.iverse.feature.R
import com.iverse.feature.component.text.OverlineText
import com.iverse.feature.component.theme.CustomSmallShapes


@Composable
fun BoxScope.NoConnectionPopUp(HasInternet: NetworkState) {

    AnimatedVisibility(
        modifier = Modifier.align(Alignment.BottomCenter),
        visible = HasInternet == NetworkState.UNCONNECTED,
        enter = slideIn(
            animationSpec = tween(durationMillis = 500),
            initialOffset = { IntOffset(0, (it.height / 0.1F).toInt()) }),
        exit = slideOut(
            animationSpec = tween(durationMillis = 500),
            targetOffset = { IntOffset(0, (it.height / 0.1F).toInt()) })
    ) {
        Box(
            modifier = Modifier.background(Color.Red, CustomSmallShapes.small)
                .fillMaxWidth().fillMaxHeight(0.035F),
            contentAlignment = Alignment.Center
        ) {
            OverlineText(R.string.no_connection_text, fontSize = 14.sp, textColor = Color.White)
        }
    }
}