package com.iverse.feature.component.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomMediumShapes
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray
import com.iverse.feature.extensions.noRippleClickable


//TODO EDIT THIS CLASS
@Composable
fun CustomSearchTextField(
    modifier: Modifier = Modifier,
    placeholderText: String = "Placeholder",
) {
    var text by remember { mutableStateOf("") }
    val materialTheme = MaterialTheme.colors

    BasicTextField(modifier = modifier
        .background(materialTheme.onPrimary, CustomSmallShapes.medium)
        .padding(11.dp)
        .fillMaxWidth(),
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
            Row(
                modifier,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.search_logo),
                    contentDescription = null,
                    tint = materialTheme.onSecondary,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                Box(modifier = Modifier.weight(1F)) {
                    if (text.isEmpty()) Text(
                        text = placeholderText,
                        color = materialTheme.onSecondary,
                        fontSize = MaterialTheme.typography.subtitle2.fontSize
                    )
                    innerTextField()
                }
                Spacer(modifier = Modifier.padding(horizontal = 5.dp))
                if (text.isNotEmpty()) {
                    Icon(
                        painter = painterResource(id = R.drawable.close),
                        contentDescription = null,
                        tint = materialTheme.onSecondary,
                        modifier = Modifier
                            .size(20.dp)
                            .noRippleClickable { text = "" }
                    )
                }
            }
        }
    )
}