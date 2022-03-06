package com.iverse.feature.component.view

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.CustomSmallShapes

@Composable
fun ChatBubbleItem(
    message: String,
    messageColor: Color,
    BackgroundColor: Color,
    messageAlignment: Alignment,
    onDoubleTap: () -> Unit,
    onLongPress: () -> Unit,
    onTap: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxWidth(0.7F).wrapContentHeight(),
        contentAlignment = messageAlignment,
    ) {
        Surface(
            modifier = Modifier.wrapContentSize().pointerInput(Unit) {
                detectTapGestures(
                    onTap = { onTap() },
                    onDoubleTap = { onDoubleTap() },
                    onLongPress = { onLongPress() },
                )
            }.wrapContentSize(align = messageAlignment),
            shape = CustomSmallShapes.medium,
            color = BackgroundColor,
            elevation = 10.dp,
        ) {
            Text(text = message, color = messageColor)
        }
    }


}