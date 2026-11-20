package com.mrpython.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.mrpython.app.R
import com.mrpython.app.domain.Accessory
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.SnakeSkin

private fun image(skin: SnakeSkin): Int = when (skin) {
    SnakeSkin.GREEN -> R.drawable.snake_green
    SnakeSkin.YELLOW -> R.drawable.snake_yellow
    SnakeSkin.BLUE -> R.drawable.snake_blue
    SnakeSkin.CORAL -> R.drawable.snake_coral
    SnakeSkin.PURPLE -> R.drawable.snake_purple
    SnakeSkin.MAMBA -> R.drawable.snake_mamba
    SnakeSkin.GOLD -> R.drawable.snake_gold
    SnakeSkin.COSMIC -> R.drawable.snake_cosmic
}

private val Ink = Color(0xFF12161C)
private val Red = Color(0xFFE11D48)
private val DarkRed = Color(0xFF9F1239)
private val Gold = Color(0xFFF5C542)
private val Cyan = Color(0xFF22D3EE)
private val HatBlack = Color(0xFF2B3140)

/**
 * The learner's snake with its accessories. The snake is a picture (all skins share one
 * pose); accessories are drawn over it on a 100×100 grid scaled to [size].
 */
@Composable
fun SnakeAvatar(avatar: Avatar, size: Dp, modifier: Modifier = Modifier) {
    Box(modifier.size(size)) {
        Image(painterResource(image(avatar.skin)), contentDescription = null, modifier = Modifier.matchParentSize())
        Canvas(Modifier.matchParentSize()) { drawAccessories(avatar.accessories) }
    }
}

private fun DrawScope.drawAccessories(worn: List<Accessory>) {
    if (worn.isEmpty()) return
    val u = size.minDimension / 100f

    fun at(x: Float, y: Float) = Offset(x * u, y * u)
    fun dot(cx: Float, cy: Float, r: Float, color: Color, alpha: Float = 1f) =
        drawCircle(color, r * u, at(cx, cy), alpha)
    fun ring(cx: Float, cy: Float, r: Float, color: Color, width: Float) =
        drawCircle(color, r * u, at(cx, cy), style = Stroke(width * u))
    fun box(x: Float, y: Float, w: Float, h: Float, r: Float, color: Color) =
        drawRoundRect(color, at(x, y), Size(w * u, h * u), CornerRadius(r * u))
    fun line(x1: Float, y1: Float, x2: Float, y2: Float, color: Color, width: Float, alpha: Float = 1f) =
        drawLine(color, at(x1, y1), at(x2, y2), width * u, StrokeCap.Round, alpha = alpha)
    fun shape(color: Color, vararg points: Pair<Float, Float>) {
        val path = Path()
        points.forEachIndexed { i, (x, y) -> if (i == 0) path.moveTo(x * u, y * u) else path.lineTo(x * u, y * u) }
        path.close()
        drawPath(path, color)
    }
    fun curve(x1: Float, y1: Float, cx: Float, cy: Float, x2: Float, y2: Float, color: Color, width: Float, alpha: Float = 1f) {
        val path = Path()
        path.moveTo(x1 * u, y1 * u)
        path.quadraticBezierTo(cx * u, cy * u, x2 * u, y2 * u)
        drawPath(path, color, alpha, Stroke(width * u, cap = StrokeCap.Round))
    }

    // Neck.
    if (Accessory.TIE in worn) {
        shape(Color(0xFF2563EB), 48.7f to 53f, 44.5f to 57.5f, 48.7f to 76f, 52.9f to 57.5f)
        shape(Color(0xFF1E40AF), 45.2f to 53f, 52.2f to 53f, 50.7f to 57.5f, 46.7f to 57.5f)
    }
    if (Accessory.BOW_TIE in worn) {
        shape(Red, 48.7f to 56f, 38.7f to 50.5f, 38.7f to 61.5f)
        shape(Red, 48.7f to 56f, 58.7f to 50.5f, 58.7f to 61.5f)
        dot(48.7f, 56f, 2.8f, DarkRed)
    }

    // Eyes (their centres are at 39.8 and 59.4, 30.2).
    if (Accessory.GLASSES in worn) {
        ring(39.8f, 30.2f, 10.4f, Ink, 2.2f)
        ring(59.4f, 30.2f, 10.4f, Ink, 2.2f)
    }
    if (Accessory.SUNGLASSES in worn) {
        box(29.6f, 24f, 19f, 12.5f, 4.5f, Ink)
        box(50.6f, 24f, 19f, 12.5f, 4.5f, Ink)
        line(48f, 27.5f, 51f, 27.5f, Ink, 2.2f)
        line(29.6f, 28f, 25.5f, 26.5f, Ink, 2.2f)
        line(69.6f, 28f, 73.7f, 26.5f, Ink, 2.2f)
        line(33f, 27f, 38f, 27f, Color.White, 1.4f, 0.6f)
    }
    if (Accessory.MONOCLE in worn) {
        ring(59.4f, 30.2f, 10.8f, Gold, 2.2f)
        curve(68.5f, 36f, 72f, 46f, 67f, 54f, Gold, 1.2f)
    }

    // Top of the head.
    if (Accessory.CAP in worn) {
        drawArc(Red, 180f, 180f, true, at(27.6f, 8f), Size(44 * u, 29 * u))
        box(49f, 19.5f, 31f, 5.5f, 2.75f, DarkRed)
        dot(49.6f, 8.6f, 2f, DarkRed)
    }
    if (Accessory.BEANIE in worn) {
        drawArc(Color(0xFF2563EB), 180f, 180f, true, at(26.6f, 7f), Size(46 * u, 32 * u))
        box(24.6f, 18.5f, 50f, 7.5f, 3.75f, Color(0xFF93C5FD))
        dot(49.6f, 5.5f, 5f, Color.White)
    }
    if (Accessory.HEADPHONES in worn) {
        drawArc(
            HatBlack, 180f, 180f, false, at(23.6f, 9f), Size(52 * u, 48 * u),
            style = Stroke(4.5f * u, cap = StrokeCap.Round),
        )
        box(17.6f, 26f, 10.5f, 19f, 5f, Cyan)
        box(71.1f, 26f, 10.5f, 19f, 5f, Cyan)
    }
    if (Accessory.TOP_HAT in worn) {
        box(35.6f, 0.8f, 28f, 18f, 2f, HatBlack)
        box(35.6f, 12f, 28f, 4.2f, 0f, Red)
        box(25.1f, 16.6f, 49f, 5.4f, 2.7f, HatBlack)
    }
    if (Accessory.CROWN in worn) {
        shape(
            Gold, 32.1f to 21f, 30.1f to 3.5f, 40.6f to 12.5f, 49.6f to 0.8f,
            58.6f to 12.5f, 69.1f to 3.5f, 67.1f to 21f,
        )
        box(32.1f, 17.2f, 35f, 4.6f, 2f, Color(0xFFD9A400))
        dot(49.6f, 9.5f, 2.2f, Red)
        dot(37.6f, 13.8f, 1.6f, Cyan)
        dot(61.6f, 13.8f, 1.6f, Cyan)
    }

    if (Accessory.COFFEE in worn) {
        box(80f, 76f, 14f, 15.5f, 3f, Color.White)
        curve(94f, 79.5f, 99f, 83f, 94f, 87.5f, Color.White, 2.2f)
        box(82f, 78f, 10f, 3.6f, 1.8f, Color(0xFF7C4A2D))
        curve(84.5f, 72.5f, 86.3f, 69.8f, 84.5f, 67f, Color.White, 1.2f, 0.7f)
        curve(89.5f, 72.5f, 91.3f, 69.8f, 89.5f, 67f, Color.White, 1.2f, 0.7f)
    }
}
