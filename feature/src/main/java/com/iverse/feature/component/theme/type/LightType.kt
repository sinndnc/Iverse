package com.iverse.feature.component.theme.type

import androidx.compose.material.Typography
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.iverse.feature.R
import com.iverse.feature.component.theme.Gray

@Stable
private val OpenSans = FontFamily(
    Font(R.font.opensans_regular, FontWeight.Normal),
    Font(R.font.opensans_medium, FontWeight.Medium),
    Font(R.font.opensans_semibold, FontWeight.SemiBold),
    Font(R.font.opensans_bold, FontWeight.Bold),
    Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
)

@Stable
val lightTypography = Typography(
    //FOR BODY OR NORMAL TEXTS
    h1 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp
    ),
    h2 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h4 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h5 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    //NORMAL TEXT
    body1 = TextStyle(
        color = Gray.p800,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    //OVERLINE
    overline = TextStyle(
        color = Gray.p900,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    //HEADER TEXT
    h6 = TextStyle(
        color = Gray.p1000,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp
    ),
    //BUTTON TEXT
    button = TextStyle(
        color = Gray.p1000,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    //FOR SUBTITLES
    subtitle1 = TextStyle(
        color = Gray.p1000,
        fontFamily = OpenSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    //TEXT FIELD LABEL TEXT
    subtitle2 = TextStyle(
        color = Gray.p1100,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    //CAPTION TEXT
    caption = TextStyle(
        color = Gray.p1000,
        fontFamily = OpenSans,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    ),
    )