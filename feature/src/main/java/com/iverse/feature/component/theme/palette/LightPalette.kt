package com.iverse.feature.component.theme.palette

import androidx.compose.material.lightColors
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.iverse.feature.component.theme.*


@Stable
val LightColorPalette = lightColors(
    primary = Blue.p400,
    primaryVariant = Blue.p600,
    secondary = Green.p300,
    background = Color.White,
    error = Red.p500,
    onError = Specified.White,
    onPrimary = Gray.p200,
    onSurface = Gray.p500,
    onSecondary = Gray.p700,
    onBackground = Gray.p800,
    secondaryVariant = Green.p500,
    surface = Specified.White
)
