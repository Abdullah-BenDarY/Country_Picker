package com.example.countrypicker.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class Size(val value: Int) {
    VerySmall(4),
    Small(8),
    Medium(16),
    Large(24),
    ExtraLarge(32),
    Huge(36),
    ExtraHuge(42);

    @Composable
    fun toDp(): Dp {
        return with(LocalDensity.current) { value.dp }
    }
}


enum class TextSize(val value: Int) {
    ExtraSmall(11),
    Small(13),
    Medium(16),
    Large(20),
    ExtraLarge(26);

    @Composable
    fun toSp(): TextUnit {
        return with(LocalDensity.current) { value.sp }
    }
}