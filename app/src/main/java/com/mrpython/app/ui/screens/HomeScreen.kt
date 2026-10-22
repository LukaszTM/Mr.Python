package com.mrpython.app.ui.screens

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Lesson
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.theme.AppColors
import com.mrpython.app.ui.components.ChunkyButton
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.components.StatBadge

/** Horizontal offsets that make the lesson path snake left and right. */
private val pathOffsets = listOf(0, 45, 75, 45, 0, -45, -75, -45)

@Composable
fun HomeScreen(state: AppUiState, onStartLesson: (String) -> Unit) {
    val progress = state.progress
    val completed = progress.completedLessons
    val currentId = Rules.currentLessonId(CourseContent.units, completed)
    var selected by remember { mutableStateOf<Lesson?>(null) }

    Column(Modifier.fillMaxSize()) {
        TopStatsBar(state)
        HorizontalDivider(color = AppColors.Gray, thickness = 2.dp)
        LazyColumn(Modifier.fillMaxSize()) {
            item { DailyGoalCard(Rules.visibleXpToday(progress, state.today)) }
            CourseContent.units.forEachIndexed { unitIndex, unit ->
                val (color, shadow) = AppColors.unitColors[unitIndex % AppColors.unitColors.size]
                item(key = unit.id) {
                    UnitBanner(unitIndex + 1, unit.title, unit.description, color)
                }
                itemsIndexed(unit.lessons, key = { _, l -> l.id }) { i, lesson ->
                    val isDone = lesson.id in completed
                    val isUnlocked = Rules.isUnlocked(CourseContent.units, lesson.id, completed)
                    LessonNode(
                        lesson = lesson,
                        offsetDp = pathOffsets[i % pathOffsets.size],
                        color = color,
                        shadow = shadow,
                        isDone = isDone,
                        isUnlocked = isUnlocked,
                        isCurrent = lesson.id == currentId,
                        onClick = { selected = lesson },
                    )
                }
            }
            item {
                Text(
                    "Więcej lekcji wkrótce! 🐍",
                    Modifier.fillMaxWidth().padding(32.dp),
                    textAlign = TextAlign.Center,
                    color = AppColors.TextLight,
                    fontWeight = FontWeight.Bold,
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
fun TopStatsBar(state: AppUiState) {
    val p = state.progress
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        StatBadge("🐍", "Python", AppColors.Text)
        val streak = Rules.visibleStreak(p, state.today)
        StatBadge("🔥", "$streak", if (streak > 0) AppColors.Orange else AppColors.GrayDark)
        StatBadge("⚡", "${p.totalXp}", AppColors.YellowDark)
        StatBadge("❤️", "${p.hearts}", AppColors.Red)
    }
}

@Composable
private fun DailyGoalCard(xpToday: Int) {
    val goal = Rules.DAILY_GOAL_XP
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFFFF4D6))
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("🎯", fontSize = 22.sp)
            Spacer(Modifier.width(8.dp))
            Text("Cel dzienny", fontWeight = FontWeight.ExtraBold, color = AppColors.Text, fontSize = 17.sp)
            Spacer(Modifier.weight(1f))
            Text("$xpToday / $goal XP", fontWeight = FontWeight.Bold, color = AppColors.TextLight)
        }
        Spacer(Modifier.height(10.dp))
        ProgressBar(xpToday.toFloat() / goal, Modifier.fillMaxWidth(), color = AppColors.Yellow)
        if (xpToday >= goal) {
            Spacer(Modifier.height(6.dp))
            Text("Cel osiągnięty – brawo! 🎉", color = AppColors.YellowDark, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun UnitBanner(number: Int, title: String, description: String, color: Color) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color)
            .padding(18.dp)
    ) {
        Text(
            "CZĘŚĆ $number",
            color = Color.White.copy(alpha = 0.85f),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 13.sp,
            letterSpacing = 1.sp,
        )
        Text(title, color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
        Text(description, color = Color.White.copy(alpha = 0.9f), fontSize = 15.sp)
    }
}

@Composable
private fun LessonNode(
    lesson: Lesson,
    offsetDp: Int,
    color: Color,
    shadow: Color,
    isDone: Boolean,
    isUnlocked: Boolean,
    isCurrent: Boolean,
    onClick: () -> Unit,
) {
    val face = when {
        isDone -> AppColors.Yellow
        isUnlocked -> color
        else -> AppColors.Gray
    }
    val edge = when {
        isDone -> AppColors.YellowDark
        isUnlocked -> shadow
        else -> AppColors.GrayDark
    }
    val icon = when {
        isDone -> "✓"
        isUnlocked -> "★"
        else -> "🔒"
    }
    val pulse = rememberInfiniteTransition(label = "pulse")
    val scale by pulse.animateFloat(
        initialValue = 1f,
        targetValue = if (isCurrent) 1.08f else 1f,
        animationSpec = infiniteRepeatable(tween(900), RepeatMode.Reverse),
        label = "scale",
    )
    val interaction = remember { MutableInteractionSource() }
    val pressed by interaction.collectIsPressedAsState()

    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            Modifier.offset(x = offsetDp.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            if (isCurrent) {
                Text(
                    "START",
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color.White)
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    color = color,
                    fontWeight = FontWeight.ExtraBold,
                )
                Spacer(Modifier.height(4.dp))
            }
            Box(Modifier.size(76.dp).scale(scale)) {
                Box(
                    Modifier
                        .size(72.dp)
                        .offset(y = 4.dp)
                        .clip(CircleShape)
                        .background(edge)
                )
                Box(
                    Modifier
                        .size(72.dp)
                        .offset(y = if (pressed) 4.dp else 0.dp)
                        .clip(CircleShape)
                        .background(face)
                        .clickable(interaction, indication = null, onClick = onClick),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        icon,
                        color = if (isUnlocked || isDone) Color.White else AppColors.GrayDark,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                }
            }
            Spacer(Modifier.height(6.dp))
            Text(
                lesson.title,
                color = if (isUnlocked) AppColors.Text else AppColors.GrayDark,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
            )
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
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(lesson.title, fontWeight = FontWeight.ExtraBold, fontSize = 22.sp, color = AppColors.Text)
            Spacer(Modifier.height(8.dp))
            val description = when {
                !isUnlocked -> "Ukończ poprzednie lekcje, aby odblokować tę."
                isDone -> "Powtórka: ${lesson.exercises.size} zadań. Nie tracisz serc, " +
                    "a za ukończenie odzyskasz jedno ❤️."
                else -> "${lesson.exercises.size} zadań. Uważaj – każdy błąd kosztuje jedno serce!"
            }
            Text(description, color = AppColors.TextLight, textAlign = TextAlign.Center)
            Spacer(Modifier.height(20.dp))
            if (isUnlocked) {
                ChunkyButton(
                    text = if (isDone) "Powtórz +${Rules.XP_PRACTICE} XP" else "Zacznij +${Rules.XP_PER_LESSON} XP",
                    onClick = onStart,
                )
            } else {
                ChunkyButton(
                    text = "OK",
                    onClick = onDismiss,
                    color = AppColors.Blue,
                    shadowColor = AppColors.BlueDark,
                )
            }
        }
    }
}
