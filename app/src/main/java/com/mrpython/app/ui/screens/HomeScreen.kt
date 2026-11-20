package com.mrpython.app.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Events
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.EventBanner
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.components.SecondaryButton
import com.mrpython.app.ui.components.StatPill
import com.mrpython.app.ui.components.darker
import com.mrpython.app.ui.components.lighter
import com.mrpython.app.ui.components.raised
import com.mrpython.app.ui.components.timeLeft
import com.mrpython.app.ui.theme.AppColors

private enum class LessonStatus { DONE, CURRENT, OPEN, LOCKED }

@Composable
fun HomeScreen(state: AppUiState, onStartLesson: (String) -> Unit) {
    val progress = state.progress
    val completed = progress.completedLessons
    val currentId = Rules.currentLessonId(CourseContent.units, completed)
    var selected by remember { mutableStateOf<Lesson?>(null) }
    val event = state.event

    Column(Modifier.fillMaxSize()) {
        TopBar(state)
        LazyColumn(Modifier.fillMaxSize()) {
            item { MascotCard(state) }
            item {
                if (event != null) {
                    EventBanner(event, state.now, Modifier.padding(horizontal = 16.dp, vertical = 4.dp))
                } else {
                    NextEventLine(state)
                }
            }
            CourseContent.units.forEachIndexed { unitIndex, unit ->
                val color = AppColors.unitColors[unitIndex % AppColors.unitColors.size]
                item(key = unit.id) {
                    val done = unit.lessons.count { it.id in completed }
                    ModuleHeader(unitIndex + 1, unit.title, unit.description, done, unit.lessons.size, color)
                }
                itemsIndexed(unit.lessons, key = { _, l -> l.id }) { i, lesson ->
                    val status = when {
                        lesson.id in completed -> LessonStatus.DONE
                        lesson.id == currentId -> LessonStatus.CURRENT
                        Rules.isUnlocked(CourseContent.units, lesson.id, completed) -> LessonStatus.OPEN
                        else -> LessonStatus.LOCKED
                    }
                    TimelineRow(
                        lesson = lesson,
                        status = status,
                        color = color,
                        isFirst = i == 0,
                        isLast = i == unit.lessons.lastIndex,
                        onClick = { selected = lesson },
                    )
                }
            }
            item {
                Text(
                    "# ciąg dalszy nastąpi…",
                    Modifier
                        .fillMaxWidth()
                        .padding(32.dp),
                    textAlign = TextAlign.Center,
                    color = AppColors.TextFaint,
                    fontFamily = FontFamily.Monospace,
                )
            }
        }
    }

    selected?.let { lesson ->
        LessonDialog(
            lesson = lesson,
            isDone = lesson.id in completed,
            isUnlocked = Rules.isUnlocked(CourseContent.units, lesson.id, completed),
            onStart = {
                selected = null
                onStartLesson(lesson.id)
            },
            onDismiss = { selected = null },
        )
    }
}

@Composable
private fun TopBar(state: AppUiState) {
    val p = state.progress
    Row(
        Modifier
            .fillMaxWidth()
            .background(Brush.verticalGradient(listOf(AppColors.SurfaceHigh, AppColors.Background)))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = AppColors.Yellow)) { append(">>> ") }
                withStyle(SpanStyle(color = AppColors.Text)) { append("mr.python") }
            },
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )
        Spacer(Modifier.weight(1f))
        val streak = Rules.visibleStreak(p, state.today)
        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            StatPill("🔥", "$streak", if (streak > 0) AppColors.Streak else AppColors.TextFaint)
            StatPill("⚡", "${p.totalXp}", AppColors.Yellow)
            StatPill("♥", "${p.hearts}", AppColors.Heart)
        }
    }
}

/** What the mascot says today, depending on events, the streak and the daily goal. */
private fun mascotLine(state: AppUiState): String {
    val p = state.progress
    val streak = Rules.visibleStreak(p, state.today)
    val doneToday = p.lastActiveEpochDay == state.today.toEpochDay()
    val event = state.event
    return when {
        Rules.visibleXpToday(p, state.today) >= Rules.DAILY_GOAL_XP -> "Cel na dziś zrobiony. Świetna robota!"
        event != null -> "Trwa ${event.title}! Każda lekcja daje teraz XP ×${event.multiplier}."
        streak > 0 && !doneToday -> "Twoja seria: $streak dni. Jedna lekcja i dziś też się liczy!"
        doneToday -> "Dobra passa! Jeszcze trochę i cel dzienny będzie Twój."
        state.now.hour < 12 -> "Dzień dobry! Kawa, klawiatura i jedna lekcja?"
        state.now.hour < 18 -> "Hej! Gotowy na dzisiejszą lekcję?"
        else -> "Dobry wieczór! Zdążysz jeszcze z jedną lekcją."
    }
}

/** The snake mascot with a speech bubble, and the daily goal underneath. */
@Composable
private fun MascotCard(state: AppUiState) {
    val xpToday = Rules.visibleXpToday(state.progress, state.today)
    val goal = Rules.DAILY_GOAL_XP
    val bob = rememberInfiniteTransition(label = "bob")
    val lift by bob.animateFloat(
        initialValue = 0f,
        targetValue = -6f,
        animationSpec = infiniteRepeatable(tween(1200), RepeatMode.Reverse),
        label = "lift",
    )
    val shape = RoundedCornerShape(18.dp)
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 8.dp)
            .raised(AppColors.Edge, 5.dp, radius = 18.dp)
            .clip(shape)
            .background(Brush.linearGradient(listOf(Color(0xFF24364D), AppColors.Surface)))
            .border(1.5.dp, AppColors.Border, shape)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                Modifier
                    .graphicsLayer { translationY = lift * density }
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(Brush.linearGradient(listOf(AppColors.Yellow, AppColors.Blue)))
                    .border(3.dp, Color.White.copy(alpha = 0.25f), CircleShape),
                contentAlignment = Alignment.Center,
            ) { Text("🐍", fontSize = 32.sp) }
            Spacer(Modifier.width(12.dp))
            Text(
                mascotLine(state),
                Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 4.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 16.dp))
                    .background(AppColors.Background.copy(alpha = 0.6f))
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                color = AppColors.Text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                lineHeight = 20.sp,
            )
        }
        Spacer(Modifier.height(14.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🎯 Cel dzienny", color = AppColors.Text, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            Spacer(Modifier.weight(1f))
            Text(
                "$xpToday / $goal XP",
                color = if (xpToday >= goal) AppColors.Success else AppColors.Yellow,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
        }
        Spacer(Modifier.height(8.dp))
        ProgressBar(
            xpToday.toFloat() / goal,
            Modifier.fillMaxWidth(),
            color = if (xpToday >= goal) AppColors.Success else AppColors.Yellow,
            height = 14.dp,
        )
    }
}

@Composable
private fun NextEventLine(state: AppUiState) {
    val next = Events.next(state.now)
    Text(
        "⚡ Następny event: ${next.title} (XP ×${next.multiplier}) za ${timeLeft(state.now, next.startsAt)}",
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 6.dp),
        color = AppColors.TextDim,
        fontSize = 13.sp,
    )
}

@Composable
private fun ModuleHeader(number: Int, title: String, description: String, done: Int, total: Int, color: Color) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 22.dp, bottom = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "MODUŁ %02d".format(number),
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                color = AppColors.Background,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 13.sp,
                letterSpacing = 1.sp,
            )
            Spacer(Modifier.width(10.dp))
            ProgressBar(done.toFloat() / total, Modifier.weight(1f), color = color, height = 8.dp)
            Spacer(Modifier.width(10.dp))
            Text("$done/$total", color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
        }
        Spacer(Modifier.height(8.dp))
        Text(title, color = AppColors.Text, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp)
        Text(description, color = AppColors.TextDim, fontSize = 14.sp)
    }
}

/** One lesson on the vertical timeline: node + connecting line on the left, card on the right. */
@Composable
private fun TimelineRow(
    lesson: Lesson,
    status: LessonStatus,
    color: Color,
    isFirst: Boolean,
    isLast: Boolean,
    onClick: () -> Unit,
) {
    val lineColor = if (status == LessonStatus.DONE) color.copy(alpha = 0.7f) else AppColors.Border
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            Modifier
                .width(52.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Column(Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    Modifier
                        .width(4.dp)
                        .weight(1f)
                        .background(if (isFirst) Color.Transparent else lineColor)
                )
                Box(
                    Modifier
                        .width(4.dp)
                        .weight(1f)
                        .background(if (isLast) Color.Transparent else lineColor)
                )
            }
            TimelineNode(lesson, status, color)
        }
        Spacer(Modifier.width(10.dp))
        LessonCard(lesson, status, color, onClick, Modifier.padding(vertical = 7.dp))
    }
}

/** Round, raised lesson marker; the current lesson pulses. */
@Composable
private fun TimelineNode(lesson: Lesson, status: LessonStatus, color: Color) {
    val pulse = rememberInfiniteTransition(label = "pulse")
    val beat by pulse.animateFloat(
        initialValue = 1f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(tween(800), RepeatMode.Reverse),
        label = "beat",
    )
    val face = when (status) {
        LessonStatus.DONE, LessonStatus.CURRENT -> color
        LessonStatus.OPEN -> AppColors.SurfaceHigh
        LessonStatus.LOCKED -> AppColors.Surface
    }
    val icon = when {
        status == LessonStatus.LOCKED -> "🔒"
        status == LessonStatus.DONE -> "✓"
        lesson.isIntro -> "📖"
        else -> "▶"
    }
    val size = if (status == LessonStatus.CURRENT) 46.dp else 40.dp
    Box(
        Modifier
            .scale(if (status == LessonStatus.CURRENT) beat else 1f)
            .raised(face.darker(0.4f), 4.dp, radius = 50.dp)
            .size(size)
            .clip(CircleShape)
            .background(Brush.verticalGradient(listOf(face.lighter(0.2f), face)))
            .border(2.dp, if (status == LessonStatus.OPEN) color else Color.White.copy(alpha = 0.18f), CircleShape),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            icon,
            color = when (status) {
                LessonStatus.DONE, LessonStatus.CURRENT -> AppColors.Background
                LessonStatus.OPEN -> color
                LessonStatus.LOCKED -> AppColors.TextFaint
            },
            fontWeight = FontWeight.Black,
            fontSize = if (status == LessonStatus.LOCKED || lesson.isIntro && status != LessonStatus.DONE) 15.sp else 18.sp,
        )
    }
}

@Composable
private fun LessonCard(
    lesson: Lesson,
    status: LessonStatus,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()
    val depth = 5.dp
    val sink by animateDpAsState(if (pressed) depth else 0.dp, label = "sink")
    val shape = RoundedCornerShape(14.dp)
    val isCurrent = status == LessonStatus.CURRENT
    val background = if (isCurrent) {
        Brush.horizontalGradient(listOf(color.copy(alpha = 0.30f), color.copy(alpha = 0.08f)))
    } else {
        Brush.verticalGradient(listOf(AppColors.SurfaceHigh, AppColors.Surface))
    }
    Row(
        modifier
            .fillMaxWidth()
            .alpha(if (status == LessonStatus.LOCKED) 0.55f else 1f)
            .raised(if (isCurrent) color.darker(0.55f) else AppColors.Edge, depth, sink)
            .clip(shape)
            .background(AppColors.Surface)
            .background(background)
            .border(2.dp, if (isCurrent) color else AppColors.Border, shape)
            .clickable(interactionSource = interaction, indication = null, onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(lesson.title, color = AppColors.Text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            val subtitle = when {
                lesson.isIntro && status == LessonStatus.LOCKED -> "wprowadzenie · zablokowane"
                lesson.isIntro -> "wprowadzenie · teoria i przykłady"
                status == LessonStatus.DONE -> "ukończona · powtórka +${Rules.XP_PRACTICE} XP"
                status == LessonStatus.LOCKED -> "zablokowana"
                else -> "${lesson.exercises.size - lesson.cards.size} zadań · +${Rules.XP_PER_LESSON} XP"
            }
            Text(subtitle, color = AppColors.TextDim, fontSize = 13.sp)
        }
        when (status) {
            LessonStatus.CURRENT -> Text(
                "START",
                Modifier
                    .raised(color.darker(0.4f), 3.dp, radius = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(color)
                    .padding(horizontal = 12.dp, vertical = 7.dp),
                color = AppColors.Background,
                fontWeight = FontWeight.Black,
                fontSize = 13.sp,
                letterSpacing = 1.sp,
            )
            LessonStatus.DONE -> Text("↻", color = AppColors.TextDim, fontSize = 22.sp)
            else -> Unit
        }
    }
}

@Composable
private fun LessonDialog(
    lesson: Lesson,
    isDone: Boolean,
    isUnlocked: Boolean,
    onStart: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        val shape = RoundedCornerShape(16.dp)
        Column(
            Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(AppColors.Surface)
                .border(1.dp, AppColors.Border, shape)
                .padding(24.dp),
        ) {
            Text(
                "lekcja.${lesson.id}",
                color = AppColors.TextFaint,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(lesson.title, fontWeight = FontWeight.Bold, fontSize = 22.sp, color = AppColors.Text)
            Spacer(Modifier.height(10.dp))
            val description = when {
                !isUnlocked -> "Ukończ poprzednie lekcje, aby odblokować tę."
                lesson.isIntro -> "Krótkie wprowadzenie do modułu: teoria, przykłady kodu i kilka " +
                    "pytań na rozgrzewkę. Możesz do niego wracać w każdej chwili."
                isDone -> "Powtórka: losowe zadania z tej lekcji. Nie tracisz serc, " +
                    "a za ukończenie odzyskasz jedno ♥."
                else -> "${lesson.exercises.size - lesson.cards.size} zadań. Uważaj – każdy błąd kosztuje jedno ♥."
            }
            Text(description, color = AppColors.TextDim, lineHeight = 20.sp)
            Spacer(Modifier.height(20.dp))
            if (isUnlocked) {
                PrimaryButton(
                    text = if (isDone) "↻  Powtórz  +${Rules.XP_PRACTICE} XP" else "▶  Uruchom  +${Rules.XP_PER_LESSON} XP",
                    onClick = onStart,
                )
            } else {
                SecondaryButton(text = "OK", onClick = onDismiss)
            }
        }
    }
}
