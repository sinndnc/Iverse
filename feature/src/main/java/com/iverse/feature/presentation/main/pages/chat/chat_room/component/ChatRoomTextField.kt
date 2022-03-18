package com.iverse.feature.presentation.main.pages.chat.chat_room.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomMediumShapes

@Composable
fun ChatTextField(
    modifier: Modifier = Modifier,
    onClicked: (String) -> Unit
) {

    var text by remember { mutableStateOf("") }
    val materialTheme = MaterialTheme.colors
    val buttonColor =
        if (text.isNotEmpty()) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.primaryVariant.copy(0.4F)

    BasicTextField(modifier = modifier
        .padding(5.dp)
        .fillMaxWidth()
        .background(materialTheme.onPrimary, CustomMediumShapes.medium),
        value = text,
        onValueChange = {
            text = it
        },
        singleLine = true,
        cursorBrush = SolidColor(materialTheme.primary),
        textStyle = LocalTextStyle.current.copy(
            color = materialTheme.onSecondary,
            fontSize = MaterialTheme.typography.subtitle1.fontSize
        ),
        decorationBox = { innerTextField ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .weight(1F)
                ) {
                    if (text.isEmpty()) Text(
                        text = "Text Message",
                        color = materialTheme.onSecondary,
                        fontSize = MaterialTheme.typography.subtitle2.fontSize
                    )
                    innerTextField()
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                IconButton(
                    onClick = {
                        onClicked(text)
                        text = ""
                    },
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CustomMediumShapes.medium)
                        .background(buttonColor)
                ) {
                    Icon(
                        painterResource(R.drawable.arrow_up),
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }
    )
}