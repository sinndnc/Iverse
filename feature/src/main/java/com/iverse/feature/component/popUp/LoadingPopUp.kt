package com.iverse.feature.component.popUp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
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
import com.iverse.feature.component.theme.Gray

@Composable
fun BoxScope.LoadingPopUp(isProcess: Boolean) {
    AnimatedVisibility(
        modifier = Modifier.align(Alignment.BottomCenter),
        visible = isProcess,
    ) {
        Surface(
            modifier = Modifier.align(Alignment.Center),
            color = Gray.p800,
            shape = CustomSmallShapes.large,
            elevation = 50.dp,
        ) {
            CircularProgressIndicator(modifier = Modifier.padding(all = 25.dp), color = Color.White)
        }
    }
}