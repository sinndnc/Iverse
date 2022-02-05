package com.iverse.feature.component.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.popUp.NoConnectionPopUp
import com.iverse.feature.component.popUp.ReConnectionPopUp
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.core.utils.connectivity.NetworkState


@Composable
fun Container(
    alignment: Alignment = Alignment.Center,
    color: Color = MaterialTheme.colors.background,
    isProcess: Boolean,
    isHasInternet: NetworkState,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        contentAlignment = alignment
    ) {
        content()
        NoConnectionPopUp(modifier = Modifier.align(Alignment.BottomCenter), isHasInternet)
        ReConnectionPopUp(modifier = Modifier.align(Alignment.BottomCenter), isHasInternet)
        if (isProcess) {
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


}