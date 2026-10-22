package com.mrpython.app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrpython.app.domain.Answer
import com.mrpython.app.domain.ArrangeTiles
import com.mrpython.app.domain.Exercise
import com.mrpython.app.domain.FillInBlank
import com.mrpython.app.domain.MultipleChoice
import com.mrpython.app.domain.PredictOutput
import com.mrpython.app.ui.ActiveLesson
import com.mrpython.app.ui.Feedback
import com.mrpython.app.ui.components.ChunkyButton
import com.mrpython.app.ui.components.CodeBlock
import com.mrpython.app.ui.components.CodeText
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.components.StatBadge
import com.mrpython.app.ui.components.TileCard
import com.mrpython.app.ui.theme.AppColors

@Composable
fun LessonScreen(
    lesson: ActiveLesson,
    hearts: Int,
    onSubmit: (Answer) -> Unit,
    onContinue: () -> Unit,
    onQuit: () -> Unit,
) {
    val session = lesson.session
    val exercise = session.current ?: return
    val feedback = lesson.feedback
    // A re-queued exercise must start from a clean slate, so the key includes the attempt number.
    val attemptKey = "${exercise.id}#${session.solved + session.mistakes}"
    var pending by remember(attemptKey) { mutableStateOf<Answer?>(null) }
    var confirmQuit by remember { mutableStateOf(false) }
    val haptics = LocalHapticFeedback.current

    LaunchedEffect(feedback) {
        if (feedback?.correct == false) haptics.performHapticFeedback(HapticFeedbackType.LongPress)
    }
    BackHandler { confirmQuit = true }

    Column(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "✕",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { confirmQuit = true }
                    .padding(8.dp),
                fontSize = 22.sp,
                color = AppColors.GrayDark,
                fontWeight = FontWeight.Bold,
            )
            Spacer(Modifier.width(8.dp))
            ProgressBar(session.progress, Modifier.weight(1f))
            Spacer(Modifier.width(12.dp))
            if (lesson.isPractice) {
                StatBadge("💪", "", AppColors.Blue)
            } else {
                StatBadge("❤️", "$hearts", AppColors.Red)
            }
        }

        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 8.dp)
        ) {
            // Wrongly answered exercises are appended to the queue, so after the first
            // pass through the lesson everything left is a retry.
            if (session.solved + session.mistakes >= session.total) {
                Text(
                    "↻ POPRZEDNI BŁĄD",
                    color = AppColors.Orange,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 13.sp,
                )
                Spacer(Modifier.height(4.dp))
            }
            Text(
                exercise.instruction,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                color = AppColors.Text,
                lineHeight = 28.sp,
            )
            Spacer(Modifier.height(20.dp))
            ExerciseBody(
                exercise = exercise,
                attemptKey = attemptKey,
                enabled = feedback == null,
                onAnswerChange = { pending = it },
            )
            Spacer(Modifier.height(24.dp))
        }

        HorizontalDivider(color = AppColors.Gray, thickness = 2.dp)
        if (feedback == null) {
            Box(Modifier.padding(16.dp)) {
                ChunkyButton(
                    text = "Sprawdź",
                    onClick = { pending?.let(onSubmit) },
                    enabled = pending != null,
                )
            }
        }
        AnimatedVisibility(visible = feedback != null, enter = slideInVertically { it }) {
            feedback?.let { FeedbackPanel(it, onContinue) }
        }
    }

    if (confirmQuit) {
        AlertDialog(
            onDismissRequest = { confirmQuit = false },
            title = { Text("Przerwać lekcję?") },
            text = { Text("Jeśli wyjdziesz teraz, stracisz postęp w tej lekcji.") },
            confirmButton = {
                TextButton(onClick = { confirmQuit = false; onQuit() }) {
                    Text("Wyjdź", color = AppColors.Red, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmQuit = false }) {
                    Text("Ucz się dalej", color = AppColors.Blue, fontWeight = FontWeight.Bold)
                }
            },
            containerColor = Color.White,
        )
    }
}

@Composable
private fun ExerciseBody(
    exercise: Exercise,
    attemptKey: String,
    enabled: Boolean,
    onAnswerChange: (Answer?) -> Unit,
) {
    when (exercise) {
        is MultipleChoice -> MultipleChoiceBody(exercise, attemptKey, enabled, onAnswerChange)
        is FillInBlank -> FillInBlankBody(exercise, attemptKey, enabled, onAnswerChange)
        is ArrangeTiles -> ArrangeTilesBody(exercise, attemptKey, enabled, onAnswerChange)
        is PredictOutput -> PredictOutputBody(exercise, attemptKey, enabled, onAnswerChange)
    }
}

private fun looksLikeCode(text: String) =
    text.any { it in "()[]{}=\"'<>_#%/*" } || (' ' !in text && text.length <= 10)

@Composable
private fun MultipleChoiceBody(
    exercise: MultipleChoice,
    attemptKey: String,
    enabled: Boolean,
    onAnswerChange: (Answer?) -> Unit,
) {
    // Options are shuffled for display; the answer still reports the original index.
    val order = remember(attemptKey) { exercise.options.indices.shuffled() }
    var selected by remember(attemptKey) { mutableStateOf<Int?>(null) }

    exercise.code?.let {
        CodeBlock(it)
        Spacer(Modifier.height(20.dp))
    }
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        order.forEach { index ->
            val option = exercise.options[index]
            TileCard(
                modifier = Modifier.fillMaxWidth(),
                selected = selected == index,
                enabled = enabled,
                onClick = {
                    selected = index
                    onAnswerChange(Answer.Choice(index))
                },
            ) {
                if (looksLikeCode(option)) {
                    CodeText(option, fontSize = 17)
                } else {
                    Text(option, fontSize = 17.sp, color = AppColors.Text, fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FillInBlankBody(
    exercise: FillInBlank,
    attemptKey: String,
    enabled: Boolean,
    onAnswerChange: (Answer?) -> Unit,
) {
    val order = remember(attemptKey) { exercise.options.indices.shuffled() }
    var selected by remember(attemptKey) { mutableStateOf<Int?>(null) }

    val choice = selected?.let { exercise.options[it] }
    val blankAt = exercise.codeTemplate.indexOf(FillInBlank.BLANK)
    val code = exercise.codeTemplate.replace(FillInBlank.BLANK, choice ?: FillInBlank.BLANK)
    val filled = if (blankAt >= 0) blankAt until blankAt + (choice ?: FillInBlank.BLANK).length else null
    CodeBlock(code, highlight = filled)
    Spacer(Modifier.height(24.dp))
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        order.forEach { index ->
            TileCard(
                selected = selected == index,
                enabled = enabled,
                onClick = {
                    selected = index
                    onAnswerChange(Answer.Choice(index))
                },
            ) { CodeText(exercise.options[index]) }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ArrangeTilesBody(
    exercise: ArrangeTiles,
    attemptKey: String,
    enabled: Boolean,
    onAnswerChange: (Answer?) -> Unit,
) {
    val bank = remember(attemptKey) { exercise.tiles.shuffled() }
    // Positions in [bank] that the learner has placed, in order.
    var picked by remember(attemptKey) { mutableStateOf(listOf<Int>()) }

    fun update(newPicked: List<Int>) {
        picked = newPicked
        onAnswerChange(if (newPicked.isEmpty()) null else Answer.Tiles(newPicked.map { bank[it] }))
    }

    // Answer area with "notebook lines".
    Box(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 120.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            repeat(2) {
                Spacer(Modifier.height(58.dp))
                HorizontalDivider(color = AppColors.Gray, thickness = 2.dp)
            }
        }
        FlowRow(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            picked.forEach { bankIndex ->
                TileCard(enabled = enabled, onClick = { update(picked - bankIndex) }) {
                    CodeText(bank[bankIndex])
                }
            }
        }
    }
    Spacer(Modifier.height(32.dp))
    FlowRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        bank.forEachIndexed { index, tile ->
            if (index in picked) {
                // Empty slot keeps the layout stable, like Duolingo's grey placeholder.
                Box(
                    Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(AppColors.Gray)
                        .padding(horizontal = 14.dp, vertical = 10.dp)
                ) { CodeText(tile, color = AppColors.Gray) }
            } else {
                TileCard(enabled = enabled, onClick = { update(picked + index) }) { CodeText(tile) }
            }
        }
    }
}

@Composable
private fun PredictOutputBody(
    exercise: PredictOutput,
    attemptKey: String,
    enabled: Boolean,
    onAnswerChange: (Answer?) -> Unit,
) {
    var text by remember(attemptKey) { mutableStateOf("") }
    CodeBlock(exercise.code)
    Spacer(Modifier.height(20.dp))
    Text("Wynik w konsoli:", color = AppColors.TextLight, fontWeight = FontWeight.Bold)
    Spacer(Modifier.height(8.dp))
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onAnswerChange(if (it.isBlank()) null else Answer.Text(it))
        },
        enabled = enabled,
        modifier = Modifier.fillMaxWidth(),
        minLines = 2,
        placeholder = { Text("Wpisz, co pojawi się na ekranie…", fontFamily = FontFamily.Monospace) },
        textStyle = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 17.sp, color = AppColors.Text),
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None, autoCorrectEnabled = false),
        shape = RoundedCornerShape(14.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AppColors.Blue,
            unfocusedBorderColor = AppColors.Gray,
            focusedContainerColor = Color(0xFFF7F7F7),
            unfocusedContainerColor = Color(0xFFF7F7F7),
            disabledContainerColor = Color(0xFFF7F7F7),
        ),
    )
}

@Composable
private fun FeedbackPanel(feedback: Feedback, onContinue: () -> Unit) {
    val background = if (feedback.correct) AppColors.GreenLight else AppColors.RedLight
    val accent = if (feedback.correct) AppColors.GreenDark else AppColors.RedDark
    Column(
        Modifier
            .fillMaxWidth()
            .background(background)
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(if (feedback.correct) "✅" else "❌", fontSize = 24.sp)
            Spacer(Modifier.width(10.dp))
            Text(
                if (feedback.correct) praise(feedback) else "Niepoprawnie",
                color = accent,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
            )
        }
        if (!feedback.correct) {
            Spacer(Modifier.height(10.dp))
            Text("Poprawna odpowiedź:", color = accent, fontWeight = FontWeight.Bold)
            CodeText(feedback.correctAnswer, color = accent)
        }
        Spacer(Modifier.height(8.dp))
        Text(feedback.explanation, color = accent, fontSize = 15.sp)
        Spacer(Modifier.height(16.dp))
        ChunkyButton(
            text = if (feedback.correct) "Dalej" else "Rozumiem",
            onClick = onContinue,
            color = if (feedback.correct) AppColors.Green else AppColors.Red,
            shadowColor = if (feedback.correct) AppColors.GreenDark else AppColors.RedDark,
        )
    }
}

private val praises = listOf("Świetnie!", "Doskonale!", "Brawo!", "Tak trzymaj!", "Super!")

private fun praise(feedback: Feedback) = praises[Math.floorMod(feedback.explanation.hashCode(), praises.size)]
