package com.iverse.feature.component.text

import androidx.annotation.StringRes
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun CustomText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    textOverflow: TextOverflow = TextOverflow.Visible,
    maxLine: Int = 1
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        fontSize = style.fontSize,
        fontStyle = style.fontStyle,
        fontFamily = style.fontFamily,
        fontWeight = style.fontWeight,
        color = style.color,
        overflow = textOverflow,
        maxLines = maxLine
    )
}