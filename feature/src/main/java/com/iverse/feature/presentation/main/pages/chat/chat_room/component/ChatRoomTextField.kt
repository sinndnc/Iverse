package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.CustomSmallShapes

@Composable
fun RowScope.ChatTextField(
    text: MutableState<String>,
) {

    val materialTheme = MaterialTheme.colors
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp

    BasicTextField(
        modifier = Modifier
            .heightIn(min = screenHeight * 0.07f)
            .weight(1f)
            .padding(5.dp)
            .background(materialTheme.onPrimary, CustomSmallShapes.large),
        value = text.value,
        onValueChange = { text.value = it },
        cursorBrush = SolidColor(materialTheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = materialTheme.onSecondary,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        ),
        maxLines = 5,
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                contentAlignment = Alignment.CenterStart,
            ) {
                if (text.value.isEmpty()) {
                    Text(
                        text = "Type Messages...",
                        color = materialTheme.onSecondary,
                        fontSize = MaterialTheme.typography.subtitle2.fontSize
                    )
                }
                innerTextField()
            }
        }
    )
}