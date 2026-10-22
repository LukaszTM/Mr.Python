package com.mrpython.app.ui.components

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
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

/** Flat, rounded main action button that shrinks slightly when pressed. */
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
    val scale by animateFloatAsState(if (pressed && enabled) 0.97f else 1f, label = "press")
    Box(
        modifier
            .fillMaxWidth()
            .height(52.dp)
            .scale(scale)
            .clip(RoundedCornerShape(12.dp))
            .background(if (enabled) color else AppColors.SurfaceHigh)
            .clickable(interactionSource = interaction, indication = null, enabled = enabled, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = text,
            color = if (enabled) contentColor else AppColors.TextFaint,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

/** Outlined button for secondary or destructive actions. */
@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Text,
) {
    val shape = RoundedCornerShape(12.dp)
    Box(
        modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(shape)
            .border(1.5.dp, AppColors.Border, shape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(text, color = color, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

/** Selectable answer card or code tile. */
@Composable
fun OptionCard(
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(10.dp)
    Box(
        modifier
            .clip(shape)
            .background(if (selected) AppColors.Blue.copy(alpha = 0.18f) else AppColors.Surface)
            .border(1.5.dp, if (selected) AppColors.BlueBright else AppColors.Border, shape)
            .clickable(enabled = enabled, onClick = onClick)
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

/** Thin rounded progress bar. */
@Composable
fun ProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = AppColors.Yellow,
    height: Dp = 8.dp,
) {
    val animated by animateFloatAsState(progress.coerceIn(0f, 1f), label = "progress")
    Box(
        modifier
            .height(height)
            .clip(RoundedCornerShape(50))
            .background(AppColors.SurfaceHigh)
    ) {
        if (animated > 0f) {
            Box(
                Modifier
                    .fillMaxWidth(animated)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(50))
                    .background(color)
            )
        }
    }
}

/** Small pill with an icon and a number, used for streak / XP / hearts. */
@Composable
fun StatPill(icon: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Row(
        modifier
            .clip(RoundedCornerShape(50))
            .background(AppColors.Surface)
            .border(1.dp, AppColors.Border, RoundedCornerShape(50))
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Text(icon, fontSize = 14.sp, color = color)
        if (value.isNotEmpty()) {
            Text(value, color = color, fontWeight = FontWeight.Bold, fontSize = 14.sp, fontFamily = FontFamily.Monospace)
        }
    }
}

@Composable
fun BigEmoji(emoji: String, size: Int = 72) {
    Text(emoji, fontSize = size.sp, textAlign = TextAlign.Center)
}
