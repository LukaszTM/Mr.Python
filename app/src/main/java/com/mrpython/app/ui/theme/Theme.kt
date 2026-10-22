package com.mrpython.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Dark "code editor" palette built around the Python logo colours.
 * Backgrounds are deep blue-slate rather than pure black, to keep contrast soft.
 */
object AppColors {
    val Background = Color(0xFF101822)
    val Surface = Color(0xFF172231)
    val SurfaceHigh = Color(0xFF1E2B3C)
    val Border = Color(0xFF2B3B50)
    val CodeBackground = Color(0xFF0B121A)

    val Text = Color(0xFFE3E9F1)
    val TextDim = Color(0xFF8A9AB0)
    val TextFaint = Color(0xFF56667C)

    val Yellow = Color(0xFFFFD43B)
    val OnYellow = Color(0xFF1A1400)
    val Blue = Color(0xFF4B8BBE)
    val BlueBright = Color(0xFF6CA6DD)

    val Success = Color(0xFF3FB950)
    val SuccessBackground = Color(0xFF12261A)
    val Error = Color(0xFFF2545B)
    val ErrorBackground = Color(0xFF2A1418)
    val Streak = Color(0xFFF0883E)
    val Heart = Color(0xFFF2545B)

    /** Accent colour of each course module on the learning path. */
    val unitColors = listOf(
        Yellow,
        BlueBright,
        Color(0xFF2DD4BF),
        Color(0xFFA78BFA),
        Color(0xFFFB7185),
        Color(0xFFA3E635),
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
    val LineNumber = Color(0xFF45526A)
}

private val colorScheme = darkColorScheme(
    primary = AppColors.Yellow,
    onPrimary = AppColors.OnYellow,
    secondary = AppColors.Blue,
    background = AppColors.Background,
    surface = AppColors.Surface,
    surfaceContainerHigh = AppColors.Surface,
    onBackground = AppColors.Text,
    onSurface = AppColors.Text,
    onSurfaceVariant = AppColors.TextDim,
    outline = AppColors.Border,
    error = AppColors.Error,
)

@Composable
fun MrPythonTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = colorScheme, content = content)
}
