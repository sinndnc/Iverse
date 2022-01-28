package com.iverse.feature.component.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.theme.CustomSmallShapes
import com.iverse.feature.component.theme.Gray

@Composable
fun ResourceIconButton(icon: Int, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clip(CustomSmallShapes.medium).clickable { onClick() }.background(Gray.p900).padding(10.dp)
    ) {
        Icon(painterResource(id = icon), "Icon Button", tint = Color.White)
    }
}