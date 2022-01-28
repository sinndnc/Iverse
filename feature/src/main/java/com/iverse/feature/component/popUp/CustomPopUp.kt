package com.iverse.feature.component.popUp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import com.iverse.feature.component.theme.CustomSmallShapes
import kotlin.math.roundToInt

//TODO MAKE THE CUSTOM POP UP
@Composable
fun CustomPopUp(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    var offsetY by remember { mutableStateOf(0f) }
    val draggableState = rememberDraggableState(onDelta = { delta ->
        offsetY += delta
        Log.d("draggableTest", delta.toString())
    })
    Box(
        modifier = modifier.fillMaxWidth()
            .offset { IntOffset(0, offsetY.roundToInt()) }
            .fillMaxHeight(0.35F)
            .background(Color.White, CustomSmallShapes.large),
        contentAlignment = Alignment.BottomCenter
    ) {
        content()
    }
}