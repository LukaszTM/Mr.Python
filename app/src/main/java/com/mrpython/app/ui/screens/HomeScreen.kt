package com.mrpython.app.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.components.SecondaryButton
import com.mrpython.app.ui.components.StatPill
import com.mrpython.app.ui.theme.AppColors

private enum class LessonStatus { DONE, CURRENT, OPEN, LOCKED }

@Composable
fun HomeScreen(state: AppUiState, onStartLesson: (String) -> Unit) {
    val progress = state.progress
    val completed = progress.completedLessons
    val currentId = Rules.currentLessonId(CourseContent.units, completed)
    var selected by remember { mutableStateOf<Lesson?>(null) }

    Column(Modifier.fillMaxSize()) {
        TopBar(state)
        HorizontalDivider(color = AppColors.Border, thickness = 1.dp)
        LazyColumn(Modifier.fillMaxSize()) {
            item { DailyGoalCard(Rules.visibleXpToday(progress, state.today)) }
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

@Composable
private fun DailyGoalCard(xpToday: Int) {
    val goal = Rules.DAILY_GOAL_XP
    val shape = RoundedCornerShape(12.dp)
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(shape)
            .background(AppColors.Surface)
            .border(1.dp, AppColors.Border, shape)
            .padding(16.dp)
    ) {
        Text(
            buildAnnotatedString {
                withStyle(SpanStyle(color = AppColors.BlueBright)) { append("cel_dzienny") }
                withStyle(SpanStyle(color = AppColors.TextDim)) { append(" = ") }
                withStyle(SpanStyle(color = AppColors.Yellow)) { append("$xpToday") }
                withStyle(SpanStyle(color = AppColors.TextDim)) { append(" / $goal  # XP") }
            },
            fontFamily = FontFamily.Monospace,
            fontSize = 15.sp,
        )
        Spacer(Modifier.height(10.dp))
        ProgressBar(xpToday.toFloat() / goal, Modifier.fillMaxWidth())
        if (xpToday >= goal) {
            Spacer(Modifier.height(8.dp))
            Text("✓ Cel osiągnięty – dobra robota!", color = AppColors.Success, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun ModuleHeader(number: Int, title: String, description: String, done: Int, total: Int, color: Color) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "MODUŁ %02d".format(number),
                color = color,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                letterSpacing = 1.sp,
            )
            Spacer(Modifier.width(10.dp))
            Box(
                Modifier
                    .weight(1f)
                    .height(1.dp)
                    .background(AppColors.Border)
            )
            Spacer(Modifier.width(10.dp))
            Text("$done/$total", color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
        }
        Spacer(Modifier.height(6.dp))
        Text(title, color = AppColors.Text, fontWeight = FontWeight.Bold, fontSize = 22.sp)
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
    val lineColor = if (status == LessonStatus.DONE) color.copy(alpha = 0.6f) else AppColors.Border
    Row(
        Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            Modifier
                .width(36.dp)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center,
        ) {
            Column(Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(if (isFirst) Color.Transparent else lineColor)
                )
                Box(
                    Modifier
                        .width(2.dp)
                        .weight(1f)
                        .background(if (isLast) Color.Transparent else lineColor)
                )
            }
            TimelineNode(status, color)
        }
        Spacer(Modifier.width(12.dp))
        LessonCard(lesson, status, color, onClick, Modifier.padding(vertical = 6.dp))
    }
}

@Composable
private fun TimelineNode(status: LessonStatus, color: Color) {
    val pulse = rememberInfiniteTransition(label = "pulse")
    val glow by pulse.animateFloat(
        initialValue = 0.25f,
        targetValue = 0.6f,
        animationSpec = infiniteRepeatable(tween(1100), RepeatMode.Reverse),
        label = "glow",
    )
    when (status) {
        LessonStatus.DONE -> Box(
            Modifier
                .size(26.dp)
                .clip(CircleShape)
                .background(color),
            contentAlignment = Alignment.Center,
        ) { Text("✓", color = AppColors.Background, fontWeight = FontWeight.Bold, fontSize = 14.sp) }

        LessonStatus.CURRENT -> Box(contentAlignment = Alignment.Center) {
            Box(
                Modifier
                    .size(34.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = glow))
            )
            Box(
                Modifier
                    .size(22.dp)
                    .clip(CircleShape)
                    .background(AppColors.Background)
                    .border(3.dp, color, CircleShape)
            )
        }

        LessonStatus.OPEN -> Box(
            Modifier
                .size(22.dp)
                .clip(CircleShape)
                .background(AppColors.Background)
                .border(2.dp, color, CircleShape)
        )

        LessonStatus.LOCKED -> Box(
            Modifier
                .size(18.dp)
                .clip(CircleShape)
                .background(AppColors.Background)
                .border(2.dp, AppColors.Border, CircleShape)
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
    val shape = RoundedCornerShape(12.dp)
    val isCurrent = status == LessonStatus.CURRENT
    Row(
        modifier
            .fillMaxWidth()
            .alpha(if (status == LessonStatus.LOCKED) 0.5f else 1f)
            .clip(shape)
            .background(if (isCurrent) color.copy(alpha = 0.10f) else AppColors.Surface)
            .border(if (isCurrent) 1.5.dp else 1.dp, if (isCurrent) color else AppColors.Border, shape)
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(lesson.title, color = AppColors.Text, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            val subtitle = when {
                lesson.isIntro && status == LessonStatus.LOCKED -> "📖 wprowadzenie · zablokowane"
                lesson.isIntro -> "📖 wprowadzenie · teoria i przykłady"
                status == LessonStatus.DONE -> "ukończona · powtórka +${Rules.XP_PRACTICE} XP"
                status == LessonStatus.LOCKED -> "zablokowana"
                else -> "${lesson.exercises.size} zadań · +${Rules.XP_PER_LESSON} XP"
            }
            Text(subtitle, color = AppColors.TextDim, fontSize = 13.sp, fontFamily = FontFamily.Monospace)
        }
        when (status) {
            LessonStatus.CURRENT -> Text(
                "▶ start",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
                    .padding(horizontal = 10.dp, vertical = 6.dp),
                color = AppColors.Background,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
            )
            LessonStatus.LOCKED -> Text("🔒", fontSize = 16.sp)
            LessonStatus.DONE -> Text("↻", color = AppColors.TextDim, fontSize = 20.sp)
            LessonStatus.OPEN -> Text("▶", color = color, fontSize = 16.sp)
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
                isDone -> "Powtórka: ${lesson.exercises.size} zadań. Nie tracisz serc, " +
                    "a za ukończenie odzyskasz jedno ♥."
                else -> "${lesson.exercises.size} zadań. Uważaj – każdy błąd kosztuje jedno ♥."
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
