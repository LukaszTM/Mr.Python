package com.mrpython.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object AppColors {
    val Green = Color(0xFF58CC02)
    val GreenDark = Color(0xFF58A700)
    val GreenLight = Color(0xFFD7FFB8)
    val Blue = Color(0xFF1CB0F6)
    val BlueDark = Color(0xFF1899D6)
    val BlueLight = Color(0xFFDDF4FF)
    val Red = Color(0xFFFF4B4B)
    val RedDark = Color(0xFFEA2B2B)
    val RedLight = Color(0xFFFFDFE0)
    val Orange = Color(0xFFFF9600)
    val Yellow = Color(0xFFFFC800)
    val YellowDark = Color(0xFFE5AC00)
    val Gray = Color(0xFFE5E5E5)
    val GrayDark = Color(0xFFAFAFAF)
    val Text = Color(0xFF4B4B4B)
    val TextLight = Color(0xFF777777)
    val CodeBackground = Color(0xFF1E1E2E)

    /** Each course unit gets its own colour on the learning path. */
    val unitColors = listOf(
        Green to GreenDark,
        Color(0xFF3776AB) to Color(0xFF2A5B85), // Python blue
        Color(0xFFCE82FF) to Color(0xFFA568CC),
        Orange to Color(0xFFCC7900),
        Color(0xFFFF86D0) to Color(0xFFD96BB0),
        Color(0xFF00CD9C) to Color(0xFF00A47D),
    )
}

/** Syntax colours for code snippets (Catppuccin-like). */
object CodeColors {
    val Plain = Color(0xFFCDD6F4)
    val Keyword = Color(0xFFCBA6F7)
    val Builtin = Color(0xFF89B4FA)
    val Str = Color(0xFFA6E3A1)
    val Number = Color(0xFFFAB387)
    val Comment = Color(0xFF7F849C)
}

private val colorScheme = lightColorScheme(
    primary = AppColors.Green,
    onPrimary = Color.White,
    secondary = AppColors.Blue,
    background = Color.White,
    surface = Color.White,
    onBackground = AppColors.Text,
    onSurface = AppColors.Text,
    error = AppColors.Red,
)

@Composable
fun MrPythonTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = colorScheme, content = content)
}
