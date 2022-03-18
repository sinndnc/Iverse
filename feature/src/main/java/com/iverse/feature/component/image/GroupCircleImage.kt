package com.iverse.feature.component.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
fun GroupCircleImage(
    modifier: Modifier = Modifier,
    image1: String,
    image2: String,
    size: Dp = 45.dp,
    contentScale: ContentScale = ContentScale.Fit,
) {
    Box(modifier = modifier.fillMaxHeight(0.7F)) {
        Image(
            modifier = Modifier
                .size(size)
                .clip(CircleShape)
                .background(Color.LightGray),
            painter = rememberImagePainter(image1),
            contentDescription = "group image1",
            alignment = Alignment.TopStart,
            contentScale = contentScale,
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(size + 5.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center,
        ) {
            Image(
                modifier = Modifier
                    .size(size)
                    .clip(CircleShape),
                painter =
                rememberImagePainter("https://firebasestorage.googleapis.com/v0/b/main-tokenizer-339209.appspot.com/o/profile_photo.jpg?alt=media&token=80ff4514-2192-43c3-8ad8-d83e16f9cd81"),
                contentDescription = "group image2",
                contentScale = contentScale,
            )
        }
    }
}