package com.iverse.feature.component.text

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource

@Composable
fun HeaderText(@StringRes text: Int, modifier: Modifier = Modifier, color: Color = MaterialTheme.colors.onBackground) {
    Text(
        text = stringResource(text),
        modifier = modifier,
        color = color,
        style = MaterialTheme.typography.h6,
        fontWeight = MaterialTheme.typography.h6.fontWeight
    )
}