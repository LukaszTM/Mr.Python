package com.mrpython.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrpython.app.domain.PythonHighlighter
import com.mrpython.app.domain.TokenType
import com.mrpython.app.domain.XpEvent
import com.mrpython.app.domain.t
import com.mrpython.app.ui.theme.AppColors
import com.mrpython.app.ui.theme.CodeColors
import java.time.Duration
import java.time.LocalDateTime
import kotlin.random.Random

fun Color.darker(amount: Float = 0.3f): Color = lerp(this, Color.Black, amount)

fun Color.lighter(amount: Float = 0.15f): Color = lerp(this, Color.White, amount)

/**
 * Gives an element a solid "3D" edge underneath, like a physical key. The element sits
 * [depth] above its edge and moves down by [sink] while pressed.
 */
fun Modifier.raised(edge: Color, depth: Dp, sink: Dp = 0.dp, radius: Dp = 14.dp): Modifier = this
    .padding(bottom = depth)
    .drawBehind {
        drawRoundRect(
            color = edge,
            topLeft = Offset(0f, depth.toPx()),
            size = size,
            cornerRadius = CornerRadius(radius.toPx()),
        )
    }
    .graphicsLayer { translationY = sink.toPx() }

/** Main action button with a chunky edge that sinks when pressed. */
@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Yellow,
    contentColor: Color = AppColors.OnYellow,
    enabled: Boolean = true,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val depth = 5.dp
    val sink by animateDpAsState(if (pressed && enabled) depth else 0.dp, label = "sink")
    val face = if (enabled) color else AppColors.SurfaceHigh
    val shape = RoundedCornerShape(14.dp)
    Box(
        modifier
            .fillMaxWidth()
            .raised(face.darker(0.35f), depth, sink)
            .height(52.dp)
            .clip(shape)
            .background(Brush.verticalGradient(listOf(face.lighter(0.18f), face)))
            .clickable(interactionSource = interaction, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = if (enabled) contentColor else AppColors.TextFaint,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 17.sp,
            // Long labels wrap; keep both lines centred with some air at the sides.
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp),
        )
    }
}

/** Button for secondary or destructive actions. */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Text,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val depth = 4.dp
    val sink by animateDpAsState(if (pressed) depth else 0.dp, label = "sink")
    val shape = RoundedCornerShape(14.dp)
    Box(
        modifier
            .fillMaxWidth()
            .raised(AppColors.Edge, depth, sink)
            .height(52.dp)
            .clip(shape)
            .background(AppColors.SurfaceHigh)
            .border(1.5.dp, AppColors.Border, shape)
            .clickable(interactionSource = interaction, indication = null, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text,
            Modifier.padding(horizontal = 12.dp),
            color = color,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
        )
    }
}

/** Selectable answer card or code tile; raised, and it sinks when pressed. */
@Composable
fun OptionCard(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val depth = 4.dp
    val sink by animateDpAsState(if (pressed && enabled) depth else 0.dp, label = "sink")
    val shape = RoundedCornerShape(12.dp)
    val border = if (selected) AppColors.BlueBright else AppColors.Border
    Box(
        modifier
            .raised(if (selected) AppColors.Blue.darker(0.25f) else AppColors.Edge, depth, sink, 12.dp)
            .clip(shape)
            .background(if (selected) AppColors.Blue.copy(alpha = 0.28f) else AppColors.SurfaceHigh)
            .border(2.dp, border, shape)
            .clickable(interactionSource = interaction, indication = null, enabled = enabled, onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 12.dp),
    ) {
        content()
    }
}

@Composable
fun CodeText(text: String, color: Color = AppColors.Text, fontSize: Int = 16) {
    Text(
        text = text,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        color = color,
        fontSize = fontSize.sp,
    )
}

private val codeStyle = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 15.sp, lineHeight = 22.sp)

/** Editor-like code window: file tab, line numbers and Python syntax highlighting. */
@Composable
fun CodeBlock(
    code: String,
    modifier: Modifier = Modifier,
    highlight: IntRange? = null,
    fileName: String = "main.py",
) {
    val shape = RoundedCornerShape(12.dp)
    Column(
        modifier
            .fillMaxWidth()
            .clip(shape)
            .background(AppColors.CodeBackground)
            .border(1.dp, AppColors.Border, shape)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .background(AppColors.Surface)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            listOf(Color(0xFFF2545B), Color(0xFFFFD43B), Color(0xFF3FB950)).forEach {
                Box(
                    Modifier
                        .padding(end = 6.dp)
                        .size(9.dp)
                        .clip(CircleShape)
                        .background(it.copy(alpha = 0.7f))
                )
            }
            Spacer(Modifier.width(6.dp))
            Text(fileName, color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
        Row(Modifier.padding(vertical = 12.dp)) {
            Text(
                text = (1..code.lines().size).joinToString("\n"),
                style = codeStyle,
                color = CodeColors.LineNumber,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 12.dp, end = 12.dp),
            )
            Text(
                text = highlightPython(code, highlight),
                style = codeStyle,
                softWrap = false,
                modifier = Modifier
                    .horizontalScroll(rememberScrollState())
                    .padding(end = 16.dp),
            )
        }
    }
}

/**
 * Colours [code]; the [highlight] range (the filled-in blank) gets a background
 * so the learner can see their choice.
 */
fun highlightPython(code: String, highlight: IntRange? = null): AnnotatedString = buildAnnotatedString {
    for (token in PythonHighlighter.tokenize(code)) {
        val color = when (token.type) {
            TokenType.KEYWORD -> CodeColors.Keyword
            TokenType.BUILTIN -> CodeColors.Builtin
            TokenType.STRING -> CodeColors.Str
            TokenType.NUMBER -> CodeColors.Number
            TokenType.COMMENT -> CodeColors.Comment
            TokenType.PLAIN -> CodeColors.Plain
        }
        withStyle(SpanStyle(color = color)) { append(token.text) }
    }
    if (highlight != null && !highlight.isEmpty()) {
        addStyle(
            SpanStyle(background = Color(0x55FFD43B), color = Color(0xFFFFE680), fontWeight = FontWeight.Bold),
            highlight.first,
            highlight.last + 1,
        )
    }
}

/** Rounded progress bar with a gradient fill and a glossy highlight. */
@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Yellow,
    height: Dp = 12.dp,
) {
    val animated by animateFloatAsState(progress.coerceIn(0f, 1f), tween(500), label = "progress")
    Box(
        modifier
            .height(height)
            .clip(RoundedCornerShape(50))
            .background(AppColors.Edge)
    ) {
        if (animated > 0f) {
            Box(
                Modifier
                    .fillMaxWidth(animated)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(Brush.horizontalGradient(listOf(color.darker(0.15f), color.lighter(0.2f))))
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 6.dp, vertical = height / 5)
                        .height(height / 4)
                        .clip(RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.35f))
                )
            }
        }
    }
}

/** Small raised pill with an icon and a number, used for streak / XP / hearts. */
@Composable
fun StatPill(icon: String, value: String, color: Color, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(50)
    Row(
        modifier
            .raised(AppColors.Edge, 3.dp, radius = 50.dp)
            .clip(shape)
            .background(AppColors.SurfaceHigh)
            .border(1.5.dp, color.copy(alpha = 0.45f), shape)
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(icon, fontSize = 15.sp, color = color)
        if (value.isNotEmpty()) {
            Text(value, color = color, fontWeight = FontWeight.ExtraBold, fontSize = 15.sp, fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun BigEmoji(emoji: String, size: Int = 72) {
    Text(emoji, fontSize = size.sp, textAlign = TextAlign.Center)
}

/** "2 d 3 h", "3 h 12 min" or "12 min" until [end]. */
fun timeLeft(now: LocalDateTime, end: LocalDateTime): String {
    val minutes = Duration.between(now, end).toMinutes().coerceAtLeast(0)
    val days = minutes / (24 * 60)
    val hours = (minutes / 60) % 24
    return when {
        days > 0 -> "$days d $hours h"
        hours > 0 -> "$hours h ${minutes % 60} min"
        else -> "${minutes % 60 + 1} min"
    }
}

/** Bright banner shown while an XP event is running. */
@Composable
fun EventBanner(event: XpEvent, now: LocalDateTime, modifier: Modifier = Modifier) {
    val pulse = rememberInfiniteTransition(label = "event")
    val scale by pulse.animateFloat(
        initialValue = 1f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(tween(700), RepeatMode.Reverse),
        label = "badge",
    )
    val shape = RoundedCornerShape(16.dp)
    Row(
        modifier
            .fillMaxWidth()
            .raised(AppColors.EventEnd.darker(0.45f), 5.dp, radius = 16.dp)
            .clip(shape)
            .background(Brush.horizontalGradient(listOf(AppColors.EventStart, AppColors.EventEnd)))
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            Modifier
                .scale(scale)
                .size(56.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Text("×${event.multiplier}", color = AppColors.EventEnd, fontWeight = FontWeight.Black, fontSize = 24.sp)
        }
        Spacer(Modifier.width(14.dp))
        Column(Modifier.weight(1f)) {
            Text("⚡ ${event.title}", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            Text(event.description, color = Color.White.copy(alpha = 0.92f), fontSize = 13.sp, lineHeight = 17.sp)
            Spacer(Modifier.height(4.dp))
            Text(
                "do końca: {0}".t(timeLeft(now, event.endsAt)),
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
            )
        }
    }
}

private class ConfettiPiece(
    val x: Float,
    val drift: Float,
    val speed: Float,
    val delay: Float,
    val size: Float,
    val spin: Float,
    val color: Color,
)

/** A burst of falling confetti, drawn over the whole screen once. */
@Composable
fun Confetti(modifier: Modifier = Modifier) {
    val colors = listOf(AppColors.Yellow, AppColors.BlueBright, AppColors.Success, AppColors.EventEnd, AppColors.Streak)
    val pieces = remember {
        val random = Random(7)
        List(70) {
            ConfettiPiece(
                x = random.nextFloat(),
                drift = random.nextFloat() * 0.3f - 0.15f,
                speed = 0.7f + random.nextFloat() * 0.6f,
                delay = random.nextFloat() * 0.35f,
                size = 6f + random.nextFloat() * 8f,
                spin = random.nextFloat() * 720f - 360f,
                color = colors[it % colors.size],
            )
        }
    }
    val time = remember { Animatable(0f) }
    LaunchedEffect(Unit) { time.animateTo(1f, tween(2600, easing = LinearEasing)) }
    Canvas(modifier.fillMaxSize()) {
        val t = time.value
        if (t >= 1f) return@Canvas
        for (piece in pieces) {
            val local = ((t - piece.delay) / (1f - piece.delay)).coerceIn(0f, 1f)
            if (local <= 0f) continue
            val x = (piece.x + piece.drift * local) * size.width
            val y = -20f + local * piece.speed * size.height * 1.15f
            val side = piece.size * density
            rotate(piece.spin * local, pivot = Offset(x, y)) {
                drawRect(
                    color = piece.color.copy(alpha = (1f - local).coerceIn(0f, 1f) * 0.9f + 0.1f),
                    topLeft = Offset(x - side / 2, y - side / 4),
                    size = Size(side, side / 2),
                )
            }
        }
    }
}
