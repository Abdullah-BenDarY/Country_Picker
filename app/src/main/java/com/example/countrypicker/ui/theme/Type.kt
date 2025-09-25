package com.example.countrypicker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.countrypicker.R


val appFont = FontFamily(Font(R.font.kameron))
fun adaptiveLetterSpacing(fontSize: Float): Float {
    return when {
        fontSize <= 16 -> 0.1f
        fontSize <= 24 -> 0.25f
        fontSize <= 32 -> 0.32f
        else -> 0.5f
    } * fontSize
}

val typographySmall = Typography(
    bodyLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = adaptiveLetterSpacing(14f).sp,
        lineHeight = 20.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = adaptiveLetterSpacing(16f).sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = adaptiveLetterSpacing(18f).sp,
        lineHeight = 26.sp
    ),
    titleMedium = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = adaptiveLetterSpacing(20f).sp,
        lineHeight = 28.sp
    ),
    titleLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        letterSpacing = adaptiveLetterSpacing(23f).sp,
        lineHeight = 30.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
        letterSpacing = adaptiveLetterSpacing(26f).sp,
        lineHeight = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        letterSpacing = adaptiveLetterSpacing(28f).sp,
        lineHeight = 34.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = appFont,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        letterSpacing = adaptiveLetterSpacing(30f).sp,
        lineHeight = 36.sp
    ),
)

val typographyCompact = typographySmall.copy(
    bodyLarge = typographySmall.bodyLarge.copy(fontSize = 16.sp, lineHeight = 22.sp),
    bodyMedium = typographySmall.bodyMedium.copy(fontSize = 18.sp, lineHeight = 26.sp),
    titleSmall = typographySmall.titleSmall.copy(fontSize = 21.sp, lineHeight = 28.sp),
    titleMedium = typographySmall.titleMedium.copy(fontSize = 23.sp, lineHeight = 30.sp),
    titleLarge = typographySmall.titleLarge.copy(fontSize = 26.sp, lineHeight = 32.sp),
    headlineSmall = typographySmall.headlineSmall.copy(fontSize = 29.sp, lineHeight = 36.sp),
    headlineMedium = typographySmall.headlineMedium.copy(fontSize = 32.sp, lineHeight = 38.sp),
    headlineLarge = typographySmall.headlineLarge.copy(fontSize = 35.sp, lineHeight = 40.sp),
)

val typographyMedium = typographySmall.copy(
    bodyLarge = typographySmall.bodyLarge.copy(fontSize = 18.sp, lineHeight = 24.sp),
    bodyMedium = typographySmall.bodyMedium.copy(fontSize = 20.sp, lineHeight = 28.sp),
    titleSmall = typographySmall.titleSmall.copy(fontSize = 24.sp, lineHeight = 30.sp),
    titleMedium = typographySmall.titleMedium.copy(fontSize = 27.sp, lineHeight = 32.sp),
    titleLarge = typographySmall.titleLarge.copy(fontSize = 30.sp, lineHeight = 36.sp),
    headlineSmall = typographySmall.headlineSmall.copy(fontSize = 32.sp, lineHeight = 38.sp),
    headlineMedium = typographySmall.headlineMedium.copy(fontSize = 35.sp, lineHeight = 40.sp),
    headlineLarge = typographySmall.headlineLarge.copy(fontSize = 38.sp, lineHeight = 44.sp),
)

val typographyBig = typographySmall.copy(
    bodyLarge = typographySmall.bodyLarge.copy(fontSize = 26.sp, lineHeight = 32.sp),
    bodyMedium = typographySmall.bodyMedium.copy(fontSize = 29.sp, lineHeight = 36.sp),
    titleSmall = typographySmall.titleSmall.copy(fontSize = 32.sp, lineHeight = 38.sp),
    titleMedium = typographySmall.titleMedium.copy(fontSize = 36.sp, lineHeight = 42.sp),
    titleLarge = typographySmall.titleLarge.copy(fontSize = 39.sp, lineHeight = 46.sp),
    headlineSmall = typographySmall.headlineSmall.copy(fontSize = 42.sp, lineHeight = 50.sp),
    headlineMedium = typographySmall.headlineMedium.copy(fontSize = 45.sp, lineHeight = 54.sp),
    headlineLarge = typographySmall.headlineLarge.copy(fontSize = 50.sp, lineHeight = 60.sp),
)

val BoldText = TextStyle(
    fontFamily = appFont,
//    fontSize = 20.sp,
    fontSize = 23.sp,
    fontWeight = FontWeight.Bold,
    color = black,
    textAlign = TextAlign.Center,
    letterSpacing = 0.5.sp,
    lineHeight = 28.sp
)

val BodyText = TextStyle(
    fontFamily = appFont,
    textAlign = TextAlign.Center,
    fontSize = 16.sp,
    fontWeight = FontWeight.Medium,
    color = black,
    letterSpacing = 0.25.sp,
    lineHeight = 24.sp
)

val SmallText = TextStyle(
    fontFamily = appFont,
    textAlign = TextAlign.Center,
    fontSize = 13.5.sp,
    fontWeight = FontWeight.Normal,
    color = black,
    letterSpacing = 0.sp,
    lineHeight = 18.sp
)
