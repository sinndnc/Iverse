package com.iverse.feature.component.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.CustomMediumShapes

@Composable
fun ClipIcon(icon: ImageVector, backgroundColor: Color, onClicked: () -> Unit) {
    Icon(
        icon,
        contentDescription = null,
        modifier = Modifier
            .clip(CustomMediumShapes.medium)
            .background(backgroundColor)
            .clickable { onClicked() }
            .padding(3.dp),
    )
}