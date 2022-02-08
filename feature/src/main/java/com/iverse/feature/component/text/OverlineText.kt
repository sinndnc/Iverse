package com.iverse.feature.component.text

import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.iverse.feature.component.theme.Green

@Composable
fun OverlineText(@StringRes text: Int, modifier: Modifier = Modifier, fontSize: TextUnit = 12.sp, textColor: Color = Green.p400) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.overline,
        fontSize = fontSize,
        color = textColor
    )
}
