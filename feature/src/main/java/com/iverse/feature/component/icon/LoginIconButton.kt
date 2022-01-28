package com.iverse.feature.component.icon

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iverse.feature.R
import com.iverse.feature.component.theme.CustomMediumShapes
import com.iverse.feature.component.theme.Gray


@Composable
fun LoginIconButton(icon: Int, color: Color = Gray.p900, onClick: () -> Unit) {
    Box(
        modifier = Modifier.clip(CustomMediumShapes.small)
            .clickable { onClick() }.background(color).padding(21.dp)
    ) {
        Icon(
            painterResource(id = icon),
            "Icon Button",
            tint = Color.Unspecified
        )
    }
}


@Preview
@Composable
fun LoginButtonIconPreview() {
    LoginIconButton(icon = R.drawable.google_logo) {}
}