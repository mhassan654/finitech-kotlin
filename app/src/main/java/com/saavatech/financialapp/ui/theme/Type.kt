package com.saavatech.financialapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.saavatech.financialapp.R

val sfSansFontFamily = FontFamily(
    Font(R.font.sf_regular, FontWeight.Normal),
    Font(R.font.sf_medium, FontWeight.Medium),
    Font(R.font.sf_light_italic, FontWeight.Light),
    Font(R.font.sf_black_bold, FontWeight.Bold),
    Font(R.font.sf_medium_italic, FontWeight.Medium),
    Font(R.font.sf_black_italic, FontWeight.Normal),
    Font(R.font.sf_thin_italic, FontWeight.Thin),
    Font(R.font.sf_ultra_light_italic, FontWeight.ExtraLight)

)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = sfSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
//    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily =sfSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = sfSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
//    */
)