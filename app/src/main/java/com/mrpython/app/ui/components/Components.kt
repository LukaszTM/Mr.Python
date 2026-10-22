package com.mrpython.app.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
import com.mrpython.app.ui.theme.AppColors
import com.mrpython.app.ui.theme.CodeColors

/** The chunky, "3D" button known from Duolingo: a darker edge below that sinks when pressed. */
@Composable
fun ChunkyButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Green,
    shadowColor: Color = AppColors.GreenDark,
    textColor: Color = Color.White,
    enabled: Boolean = true,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val depth = 4.dp
    val sink by animateDpAsState(if (pressed && enabled) depth else 0.dp, label = "sink")
    val shape = RoundedCornerShape(16.dp)
    val face = if (enabled) color else AppColors.Gray
    val edge = if (enabled) shadowColor else AppColors.Gray.copy(alpha = 0.9f)

    Box(modifier = modifier.fillMaxWidth().height(50.dp + depth)) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .offset(y = depth)
                .background(edge, shape)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .offset(y = sink)
                .clip(shape)
                .background(face)
                .clickable(interactionSource = interaction, indication = null, enabled = enabled, onClick = onClick),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text.uppercase(),
                color = if (enabled) textColor else AppColors.GrayDark,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 16.sp,
                letterSpacing = 0.8.sp,
            )
        }
    }
}

/** Selectable answer card / word-bank tile with a bottom edge. */
@Composable
fun TileCard(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(12.dp)
    val border = if (selected) AppColors.Blue else AppColors.Gray
    val edge = if (selected) AppColors.BlueDark.copy(alpha = 0.5f) else AppColors.Gray
    val background = if (selected) AppColors.BlueLight else Color.White
    Box(modifier) {
        Box(
            Modifier
                .matchParentSize()
                .padding(top = 3.dp)
                .background(edge, shape)
        )
        Box(
            Modifier
                .padding(bottom = 3.dp)
                .clip(shape)
                .background(background)
                .border(2.dp, border, shape)
                .clickable(enabled = enabled, onClick = onClick)
                .padding(horizontal = 14.dp, vertical = 10.dp),
        ) {
            content()
        }
    }
}

@Composable
fun CodeText(text: String, color: Color = AppColors.Text, fontSize: Int = 16) {
    Text(
        text = text,
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.SemiBold,
        color = color,
        fontSize = fontSize.sp,
    )
}

/** Dark code card with Python syntax highlighting. */
@Composable
fun CodeBlock(code: String, modifier: Modifier = Modifier, highlight: IntRange? = null) {
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(AppColors.CodeBackground)
            .horizontalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = highlightPython(code, highlight),
            style = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 15.sp, lineHeight = 22.sp),
            softWrap = false,
        )
    }
}

/**
 * Colours [code]; the [highlight] range (the filled-in blank) gets a light
 * background so the learner can see their choice.
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
            SpanStyle(background = Color(0x553776AB), fontWeight = FontWeight.Bold),
            highlight.first,
            highlight.last + 1,
        )
    }
}

/** Rounded progress bar used in lessons and for the daily goal. */
@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Green,
    height: Dp = 16.dp,
) {
    val animated by animateFloatAsState(progress.coerceIn(0f, 1f), label = "progress")
    Box(
        modifier
            .height(height)
            .clip(RoundedCornerShape(50))
            .background(AppColors.Gray)
    ) {
        if (animated > 0f) {
            Box(
                Modifier
                    .fillMaxWidth(animated)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(color)
            ) {
                // Highlight stripe, as on Duolingo's progress bar.
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = height / 5)
                        .height(height / 5)
                        .clip(RoundedCornerShape(50))
                        .background(Color.White.copy(alpha = 0.3f))
                )
            }
        }
    }
}

@Composable
fun StatBadge(icon: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(icon, fontSize = 20.sp)
        Spacer(Modifier.width(4.dp))
        Text(value, color = color, fontWeight = FontWeight.ExtraBold, fontSize = 17.sp)
    }
}

@Composable
fun BigEmoji(emoji: String, size: Int = 72) {
    Text(emoji, fontSize = size.sp, textAlign = TextAlign.Center)
}
