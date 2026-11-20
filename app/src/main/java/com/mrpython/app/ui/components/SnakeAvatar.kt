package com.mrpython.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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

/** The picture of each accessory. */
private fun art(accessory: Accessory): Art = when (accessory) {
    Accessory.CAP -> Art(R.drawable.acc_cap, 27.5f, -1f, 43f, aspect = 1.51f, rotation = -9f)
    Accessory.HEADPHONES -> Art(R.drawable.acc_headphones, 19.5f, 8.5f, 59f, aspect = 1.441f)
    Accessory.BEANIE -> Art(R.drawable.acc_beanie, 25.2f, 0f, 48f, aspect = 1.627f)
    Accessory.TOP_HAT -> Art(R.drawable.acc_top_hat, 29.7f, 0.5f, 39f, aspect = 1.53f, rotation = -7f)
    Accessory.CROWN -> Art(R.drawable.acc_crown, 31.2f, 5.5f, 36f, aspect = 1.714f, rotation = -6f)
    Accessory.GLASSES -> Art(R.drawable.acc_glasses, 27.4f, 24f, 44f, aspect = 2.043f)
    Accessory.SUNGLASSES -> Art(R.drawable.acc_sunglasses, 27.4f, 24.9f, 44f, aspect = 2.233f)
    Accessory.MONOCLE -> Art(R.drawable.acc_monocle, 46.9f, 22.6f, 27f, aspect = 0.909f)
    Accessory.COFFEE -> Art(R.drawable.acc_coffee, 1f, 72.5f, 20f, aspect = 0.87f)
    Accessory.BOW_TIE -> Art(R.drawable.acc_bow_tie, 38f, 53.5f, 22f, aspect = 2.098f)
    Accessory.TIE -> Art(R.drawable.acc_tie, 43.5f, 55f, 11f, aspect = 0.531f)
}

/**
 * The learner's snake with its accessories. The snake is a picture (all skins share one
 * pose); accessories are pictures laid over a 100×100 grid scaled to [size].
 */
@Composable
fun SnakeAvatar(avatar: Avatar, size: Dp, modifier: Modifier = Modifier) {
    val pictures = avatar.accessories.map { art(it) }
    Box(modifier.size(size)) {
        pictures.filter { it.behind }.forEach { ArtLayer(it, size) }
        Image(painterResource(image(avatar.skin)), contentDescription = null, modifier = Modifier.matchParentSize())
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
