package com.iverse.feature.component.theme.palette

import androidx.compose.material.darkColors
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.Color
import com.iverse.feature.component.theme.*

@Stable
val DarkColorPalette = darkColors(
    primary = Blue.p400,
    primaryVariant = Blue.p600,
    secondary = Green.p300,
    background = Color.Black,
    error = Red.p500,
    onError = Specified.Black,
    onPrimary = Gray.p1100,
    onSurface = Gray.p700,
    onSecondary = Gray.p500,
    onBackground = Gray.p400,
    secondaryVariant = Green.p500,
    surface = Specified.Black,
)