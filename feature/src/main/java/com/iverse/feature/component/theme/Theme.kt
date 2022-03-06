package com.iverse.feature.component.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.iverse.core.utils.theme.AppTheme
import com.iverse.feature.component.theme.palette.DarkColorPalette
import com.iverse.feature.component.theme.palette.LightColorPalette
import com.iverse.feature.component.theme.type.darkTypography
import com.iverse.feature.component.theme.type.lightTypography


@Composable
fun IverseTheme(theme: AppTheme, content: @Composable () -> Unit) {

    val isDarkTheme: Boolean = when (theme) {
        AppTheme.LIGHT -> false
        AppTheme.DARK -> true
        AppTheme.DEFAULT -> isSystemInDarkTheme()
    }
    val colors = if (isDarkTheme) DarkColorPalette else LightColorPalette
    val types = if (isDarkTheme) darkTypography else lightTypography

    MaterialTheme(
        colors = colors,
        typography = types,
        shapes = CustomMediumShapes,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    val systemBarColor = if (isDarkTheme) Color.Transparent else Color.Transparent
    SideEffect {
        systemUiController.setSystemBarsColor(systemBarColor, darkIcons = !isDarkTheme)
    }
}