package com.iverse.feature.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CircleImage(
    image: String,
    size: Dp = 45.dp,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    contentDescription: String? = null
) {
    Image(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(Color.Transparent),
        painter = rememberImagePainter(image),
        contentDescription = contentDescription,
        alignment = alignment,
        contentScale = contentScale,
    )
}