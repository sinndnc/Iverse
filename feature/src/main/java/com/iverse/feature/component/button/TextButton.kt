package com.iverse.feature.component.button

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun ButtonText(@StringRes text: Int, modifier: Modifier = Modifier) {
    Text(text = stringResource(id = text), modifier = modifier, style = MaterialTheme.typography.button)
}