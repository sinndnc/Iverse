package com.iverse.feature.component.button

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.iverse.feature.component.theme.CustomSmallShapes


@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    text: Int,
    isEnabled: Boolean,
    onClicked: () -> Unit,
) {
    Button(
        modifier = modifier.fillMaxWidth().fillMaxHeight(0.25F),
        enabled = !isEnabled,
        shape = CustomSmallShapes.medium,
        onClick = { onClicked() }) {
        ButtonSingleText(text)
    }

}
