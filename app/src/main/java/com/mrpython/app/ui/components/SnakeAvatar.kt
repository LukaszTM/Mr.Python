package com.mrpython.app.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
 * A picture of an accessory and where it goes on the 100×100 grid. [behind] ones are
 * drawn under the snake, so only the parts sticking out from behind the head show.
 */
private class Art(
    val image: Int,
    val x: Float,
    val y: Float,
    val width: Float,
    val aspect: Float,
    val behind: Boolean = false,
    val rotation: Float = 0f,
)

/** Accessories that have 3D artwork; the others are drawn in code. */
private fun art(accessory: Accessory): Art? = when (accessory) {
    Accessory.CAP -> Art(R.drawable.acc_cap, 27.5f, -1f, 43f, aspect = 1.51f, rotation = -9f)
    Accessory.HEADPHONES -> Art(R.drawable.acc_headphones, 19.5f, 8.5f, 59f, aspect = 1.441f)
    Accessory.BEANIE -> Art(R.drawable.acc_beanie, 25.2f, 0f, 48f, aspect = 1.627f)
    Accessory.TOP_HAT -> Art(R.drawable.acc_top_hat, 29.7f, 0.5f, 39f, aspect = 1.53f, rotation = -7f)
    Accessory.CROWN -> Art(R.drawable.acc_crown, 31.2f, 5.5f, 36f, aspect = 1.714f, rotation = -6f)
    else -> null
}

/**
 * The learner's snake with its accessories. The snake is a picture (all skins share one
 * pose); accessories are pictures or drawings laid over a 100×100 grid scaled to [size].
 */
@Composable
fun SnakeAvatar(avatar: Avatar, size: Dp, modifier: Modifier = Modifier) {
    val pictures = avatar.accessories.mapNotNull { art(it) }
    Box(modifier.size(size)) {
        pictures.filter { it.behind }.forEach { ArtLayer(it, size) }
        Image(painterResource(image(avatar.skin)), contentDescription = null, modifier = Modifier.matchParentSize())
        Canvas(Modifier.matchParentSize()) { drawAccessories(avatar.accessories.filter { art(it) == null }) }
        pictures.filterNot { it.behind }.forEach { ArtLayer(it, size) }
    }
}

@Composable
private fun ArtLayer(art: Art, size: Dp) {
    val unit = size / 100f
    Image(
        painterResource(art.image),
        contentDescription = null,
        modifier = Modifier
            .offset(x = unit * art.x, y = unit * art.y)
            .size(width = unit * art.width, height = unit * (art.width / art.aspect))
            .rotate(art.rotation),
    )
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
        shape(Color(0xFF2563EB), 49f to 54.5f, 44.8f to 59f, 49f to 76f, 53.2f to 59f)
        shape(Color(0xFF1E40AF), 45.5f to 54.5f, 52.5f to 54.5f, 51f to 59f, 47f to 59f)
    }
    if (Accessory.BOW_TIE in worn) {
        shape(Red, 49f to 57f, 39f to 51.5f, 39f to 62.5f)
        shape(Red, 49f to 57f, 59f to 51.5f, 59f to 62.5f)
        dot(49f, 57f, 2.8f, DarkRed)
    }

    // Eyes (their centres are at 40.3 and 58.3, 34.6).
    if (Accessory.GLASSES in worn) {
        ring(40.3f, 34.6f, 10f, Ink, 2.2f)
        ring(58.3f, 34.6f, 10f, Ink, 2.2f)
    }
    if (Accessory.SUNGLASSES in worn) {
        box(30f, 28.5f, 18.6f, 12.5f, 4.5f, Ink)
        box(50f, 28.5f, 18.6f, 12.5f, 4.5f, Ink)
        line(48f, 32f, 51f, 32f, Ink, 2.2f)
        line(30f, 32.5f, 26f, 31f, Ink, 2.2f)
        line(68.6f, 32.5f, 72.6f, 31f, Ink, 2.2f)
        line(33.5f, 31.5f, 38.5f, 31.5f, Color.White, 1.4f, 0.6f)
    }
    if (Accessory.MONOCLE in worn) {
        ring(58.3f, 34.6f, 10.4f, Gold, 2.2f)
        curve(67f, 40.5f, 70.5f, 50f, 66f, 57f, Gold, 1.2f)
    }

    // Top of the head (it starts at y = 17).
    if (Accessory.CAP in worn) {
        drawArc(Red, 180f, 180f, true, at(27.2f, 11.5f), Size(44 * u, 30 * u))
        box(48.6f, 23.5f, 31f, 5.5f, 2.75f, DarkRed)
        dot(49.2f, 12f, 2f, DarkRed)
    }
    if (Accessory.BEANIE in worn) {
        drawArc(Color(0xFF2563EB), 180f, 180f, true, at(26.2f, 10.5f), Size(46 * u, 33 * u))
        box(24.2f, 22.5f, 50f, 7.5f, 3.75f, Color(0xFF93C5FD))
        dot(49.2f, 9f, 5f, Color.White)
    }
    if (Accessory.HEADPHONES in worn) {
        drawArc(
            HatBlack, 180f, 180f, false, at(23.2f, 12.5f), Size(52 * u, 49 * u),
            style = Stroke(4.5f * u, cap = StrokeCap.Round),
        )
        box(17.2f, 30f, 10.5f, 19f, 5f, Cyan)
        box(70.7f, 30f, 10.5f, 19f, 5f, Cyan)
    }
    if (Accessory.TOP_HAT in worn) {
        box(35.2f, 3f, 28f, 19f, 2f, HatBlack)
        box(35.2f, 15f, 28f, 4.2f, 0f, Red)
        box(24.7f, 20f, 49f, 5.4f, 2.7f, HatBlack)
    }
    if (Accessory.CROWN in worn) {
        shape(
            Gold, 31.7f to 24.5f, 29.7f to 7f, 40.2f to 16f, 49.2f to 4.3f,
            58.2f to 16f, 68.7f to 7f, 66.7f to 24.5f,
        )
        box(31.7f, 20.7f, 35f, 4.6f, 2f, Color(0xFFD9A400))
        dot(49.2f, 13f, 2.2f, Red)
        dot(37.2f, 17.3f, 1.6f, Cyan)
        dot(61.2f, 17.3f, 1.6f, Cyan)
    }

    // The mug stands on the left; the tail is on the right.
    if (Accessory.COFFEE in worn) {
        box(5f, 77f, 14f, 15.5f, 3f, Color.White)
        curve(5f, 80.5f, 0f, 84f, 5f, 88.5f, Color.White, 2.2f)
        box(7f, 79f, 10f, 3.6f, 1.8f, Color(0xFF7C4A2D))
        curve(9.5f, 73.5f, 11.3f, 70.8f, 9.5f, 68f, Color.White, 1.2f, 0.7f)
        curve(14.5f, 73.5f, 16.3f, 70.8f, 14.5f, 68f, Color.White, 1.2f, 0.7f)
    }
}
