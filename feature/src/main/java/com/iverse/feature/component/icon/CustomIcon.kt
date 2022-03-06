package com.iverse.feature.component.icon

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.iverse.feature.component.box.PointBox
import com.iverse.feature.extensions.noRippleClickable


@Composable
fun CustomIcon(
    @DrawableRes icon: Int,
    isSelected: Boolean,
    onItemSelected: () -> Unit
) {
    val materialTheme = MaterialTheme.colors
    val backgroundColor by animateColorAsState(if (isSelected) materialTheme.primary.copy(0.7F) else materialTheme.onSurface)
    val color by animateColorAsState(targetValue = if (isSelected) materialTheme.primary else Color.Transparent)

    Column(
        modifier = Modifier.noRippleClickable { onItemSelected() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = backgroundColor
        )
        Spacer(modifier = Modifier.padding(vertical = 5.dp))
        PointBox(color)
    }

}



