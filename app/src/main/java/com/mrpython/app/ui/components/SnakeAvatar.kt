package com.mrpython.app.ui.components

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.unit.Dp
import com.mrpython.app.domain.Accessory
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.SnakeSkin

/** Body, belly and spot colours of a snake. */
private class SkinColors(val body: Color, val belly: Color, val spots: Color)

private fun colors(skin: SnakeSkin) = when (skin) {
    SnakeSkin.GREEN -> SkinColors(Color(0xFF4CC35B), Color(0xFFB9F2A1), Color(0xFF2E8B3D))
    SnakeSkin.YELLOW -> SkinColors(Color(0xFFFFD43B), Color(0xFFFFF3B0), Color(0xFFD9A400))
    SnakeSkin.BLUE -> SkinColors(Color(0xFF4B8BBE), Color(0xFFBFE0FA), Color(0xFF2F6594))
    SnakeSkin.CORAL -> SkinColors(Color(0xFFF2545B), Color(0xFFFFE1A8), Color(0xFF1E1E24))
    SnakeSkin.PURPLE -> SkinColors(Color(0xFFA78BFA), Color(0xFFE9DDFF), Color(0xFF6D4FD1))
    SnakeSkin.MAMBA -> SkinColors(Color(0xFF465066), Color(0xFF5EEAD4), Color(0xFF1B202B))
    SnakeSkin.GOLD -> SkinColors(Color(0xFFF5C542), Color(0xFFFFF6CF), Color(0xFFB8860B))
    SnakeSkin.COSMIC -> SkinColors(Color(0xFF7C3AED), Color(0xFFF0ABFC), Color(0xFF22D3EE))
}

private val Ink = Color(0xFF12161C)
private val Red = Color(0xFFE11D48)
private val DarkRed = Color(0xFF9F1239)
private val Gold = Color(0xFFF5C542)
private val Cyan = Color(0xFF22D3EE)
private val HatBlack = Color(0xFF2B3140)

/** The learner's snake with its accessories, drawn on a 100×100 grid scaled to [size]. */
@Composable
fun SnakeAvatar(avatar: Avatar, size: Dp, modifier: Modifier = Modifier) {
    Canvas(modifier.size(size)) { drawSnake(avatar) }
}

private fun DrawScope.drawSnake(avatar: Avatar) {
    val u = size.minDimension / 100f
    val skin = colors(avatar.skin)
    val worn = avatar.accessories

    fun at(x: Float, y: Float) = Offset(x * u, y * u)
    fun oval(cx: Float, cy: Float, rx: Float, ry: Float, color: Color, alpha: Float = 1f) =
        drawOval(color, at(cx - rx, cy - ry), Size(2 * rx * u, 2 * ry * u), alpha)
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

    // Coiled body, tail and spots.
    oval(50f, 83f, 34f, 15f, skin.body)
    oval(50f, 86f, 22f, 7f, skin.belly)
    curve(80f, 80f, 94f, 76f, 90f, 64f, skin.body, 6f)
    for ((x, y) in listOf(24f to 80f, 36f to 74f, 64f to 74f, 76f to 80f)) dot(x, y, 2.6f, skin.spots)

    // Neck.
    box(40f, 52f, 20f, 32f, 9f, skin.body)
    box(45f, 62f, 10f, 22f, 5f, skin.belly)

    if (Accessory.TIE in worn) {
        shape(Color(0xFF2563EB), 50f to 68f, 45f to 73f, 50f to 93f, 55f to 73f)
        shape(Color(0xFF1E40AF), 46f to 68f, 54f to 68f, 52f to 73f, 48f to 73f)
    }
    if (Accessory.BOW_TIE in worn) {
        shape(Red, 50f to 72f, 39f to 66f, 39f to 78f)
        shape(Red, 50f to 72f, 61f to 66f, 61f to 78f)
        dot(50f, 72f, 3f, DarkRed)
    }

    // Forked tongue.
    line(50f, 62f, 50f, 70f, Red, 1.8f)
    line(50f, 70f, 47f, 73f, Red, 1.8f)
    line(50f, 70f, 53f, 73f, Red, 1.8f)

    // Head, muzzle and cheeks.
    oval(50f, 45f, 27f, 22f, skin.body)
    oval(50f, 54f, 15f, 9f, skin.belly)
    dot(30f, 52f, 4f, Color(0xFFFF8FA3), 0.55f)
    dot(70f, 52f, 4f, Color(0xFFFF8FA3), 0.55f)

    // Eyes looking slightly inwards, and a smile.
    dot(39f, 42f, 7.5f, Color.White)
    dot(40f, 43f, 3.8f, Ink)
    dot(41.2f, 41.5f, 1.3f, Color.White)
    dot(61f, 42f, 7.5f, Color.White)
    dot(60f, 43f, 3.8f, Ink)
    dot(61.2f, 41.5f, 1.3f, Color.White)
    curve(43f, 55f, 50f, 60f, 57f, 55f, Ink, 1.8f)

    if (Accessory.GLASSES in worn) {
        ring(39f, 42f, 9.5f, Ink, 2.2f)
        ring(61f, 42f, 9.5f, Ink, 2.2f)
        line(48.5f, 42f, 51.5f, 42f, Ink, 2.2f)
    }
    if (Accessory.SUNGLASSES in worn) {
        box(28f, 36f, 20f, 12f, 4f, Ink)
        box(52f, 36f, 20f, 12f, 4f, Ink)
        line(48f, 40f, 52f, 40f, Ink, 2.2f)
        line(28f, 40f, 23f, 38f, Ink, 2.2f)
        line(72f, 40f, 77f, 38f, Ink, 2.2f)
        line(32f, 39f, 37f, 39f, Color.White, 1.4f, 0.6f)
    }
    if (Accessory.MONOCLE in worn) {
        ring(61f, 42f, 9.5f, Gold, 2.2f)
        curve(69f, 47f, 74f, 58f, 70f, 68f, Gold, 1.2f)
    }

    if (Accessory.CAP in worn) {
        drawArc(Red, 180f, 180f, true, at(26f, 12f), Size(48 * u, 40 * u))
        box(50f, 29f, 34f, 6f, 3f, DarkRed)
        dot(50f, 13f, 2.2f, DarkRed)
    }
    if (Accessory.BEANIE in worn) {
        drawArc(Color(0xFF2563EB), 180f, 180f, true, at(25f, 10f), Size(50 * u, 44 * u))
        box(23f, 27f, 54f, 8f, 4f, Color(0xFF93C5FD))
        dot(50f, 9f, 5.5f, Color.White)
    }
    if (Accessory.HEADPHONES in worn) {
        drawArc(
            HatBlack, 180f, 180f, false, at(22f, 14f), Size(56 * u, 60 * u),
            style = Stroke(4.5f * u, cap = StrokeCap.Round),
        )
        box(15f, 36f, 11f, 20f, 5f, Cyan)
        box(74f, 36f, 11f, 20f, 5f, Cyan)
    }
    if (Accessory.TOP_HAT in worn) {
        box(34f, 3f, 32f, 26f, 2f, HatBlack)
        box(34f, 20f, 32f, 5f, 0f, Red)
        box(22f, 26f, 56f, 6f, 3f, HatBlack)
    }
    if (Accessory.CROWN in worn) {
        shape(Gold, 30f to 31f, 28f to 10f, 40f to 21f, 50f to 6f, 60f to 21f, 72f to 10f, 70f to 31f)
        box(30f, 27f, 40f, 5f, 2f, Color(0xFFD9A400))
        dot(50f, 17f, 2.4f, Red)
        dot(36f, 22f, 1.8f, Cyan)
        dot(64f, 22f, 1.8f, Cyan)
    }

    if (Accessory.COFFEE in worn) {
        box(76f, 72f, 16f, 17f, 3f, Color.White)
        curve(92f, 76f, 98f, 80f, 92f, 85f, Color.White, 2.4f)
        box(78f, 74f, 12f, 4f, 2f, Color(0xFF7C4A2D))
        curve(81f, 68f, 83f, 65f, 81f, 62f, Color.White, 1.3f, 0.7f)
        curve(87f, 68f, 89f, 65f, 87f, 62f, Color.White, 1.3f, 0.7f)
    }
}
