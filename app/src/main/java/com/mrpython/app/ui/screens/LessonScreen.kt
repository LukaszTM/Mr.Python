package com.mrpython.app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import com.mrpython.app.ui.components.CodeBlock
import com.mrpython.app.ui.components.CodeText
import com.mrpython.app.ui.components.OptionCard
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.components.StatPill
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
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "✕",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { confirmQuit = true }
                    .padding(8.dp),
                fontSize = 20.sp,
                color = AppColors.TextDim,
            )
            Spacer(Modifier.width(8.dp))
            ProgressBar(session.progress, Modifier.weight(1f))
            Spacer(Modifier.width(8.dp))
            Text(
                "${session.solved}/${session.total}",
                color = AppColors.TextDim,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
            )
            Spacer(Modifier.width(10.dp))
            if (lesson.isPractice) {
                StatPill("↻", "", AppColors.BlueBright)
            } else {
                StatPill("♥", "$hearts", AppColors.Heart)
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
            val label = if (session.solved + session.mistakes >= session.total) "# poprawka" else "# zadanie"
            Text(
                label,
                color = if (label == "# poprawka") AppColors.Streak else AppColors.TextFaint,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
            )
            Spacer(Modifier.height(4.dp))
            Text(
                exercise.instruction,
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
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

        if (feedback == null) {
            HorizontalDivider(color = AppColors.Border, thickness = 1.dp)
            Box(Modifier.padding(16.dp)) {
                PrimaryButton(
                    text = "▶  Sprawdź",
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
                    Text("Wyjdź", color = AppColors.Error, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmQuit = false }) {
                    Text("Ucz się dalej", color = AppColors.Yellow, fontWeight = FontWeight.Bold)
                }
            },
            containerColor = AppColors.Surface,
            titleContentColor = AppColors.Text,
            textContentColor = AppColors.TextDim,
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
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        order.forEachIndexed { position, index ->
            val option = exercise.options[index]
            OptionCard(
                modifier = Modifier.fillMaxWidth(),
                selected = selected == index,
                enabled = enabled,
                onClick = {
                    selected = index
                    onAnswerChange(Answer.Choice(index))
                },
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        "${'A' + position}",
                        color = if (selected == index) AppColors.BlueBright else AppColors.TextFaint,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold,
                    )
                    Spacer(Modifier.width(14.dp))
                    if (looksLikeCode(option)) {
                        CodeText(option, fontSize = 16)
                    } else {
                        Text(option, fontSize = 16.sp, color = AppColors.Text)
                    }
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
            OptionCard(
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

    // Answer area styled as an interpreter prompt.
    val shape = RoundedCornerShape(12.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .heightIn(min = 110.dp)
            .clip(shape)
            .background(AppColors.CodeBackground)
            .border(1.dp, AppColors.Border, shape)
            .padding(12.dp)
    ) {
        Text(
            ">>>",
            Modifier.padding(top = 12.dp, end = 10.dp),
            color = AppColors.Yellow,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
        )
        FlowRow(
            Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            picked.forEach { bankIndex ->
                OptionCard(selected = true, enabled = enabled, onClick = { update(picked - bankIndex) }) {
                    CodeText(bank[bankIndex])
                }
            }
        }
    }
    Spacer(Modifier.height(24.dp))
    FlowRow(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        bank.forEachIndexed { index, tile ->
            if (index in picked) {
                // Empty dashed-looking slot keeps the layout stable.
                Box(
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .border(1.5.dp, AppColors.Border, RoundedCornerShape(10.dp))
                        .padding(horizontal = 14.dp, vertical = 12.dp)
                ) { CodeText(tile, color = AppColors.Background) }
            } else {
                OptionCard(enabled = enabled, onClick = { update(picked + index) }) { CodeText(tile) }
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
    Text(
        "$ python main.py",
        color = AppColors.TextDim,
        fontFamily = FontFamily.Monospace,
        fontSize = 14.sp,
    )
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
        placeholder = {
            Text("wpisz, co wypisze program…", fontFamily = FontFamily.Monospace, color = AppColors.TextFaint)
        },
        textStyle = TextStyle(fontFamily = FontFamily.Monospace, fontSize = 16.sp, color = AppColors.Text),
        keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.None, autoCorrectEnabled = false),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = AppColors.Yellow,
            unfocusedBorderColor = AppColors.Border,
            disabledBorderColor = AppColors.Border,
            focusedContainerColor = AppColors.CodeBackground,
            unfocusedContainerColor = AppColors.CodeBackground,
            disabledContainerColor = AppColors.CodeBackground,
            disabledTextColor = AppColors.Text,
            cursorColor = AppColors.Yellow,
        ),
    )
}

@Composable
private fun FeedbackPanel(feedback: Feedback, onContinue: () -> Unit) {
    val accent = if (feedback.correct) AppColors.Success else AppColors.Error
    Column(
        Modifier
            .fillMaxWidth()
            .background(if (feedback.correct) AppColors.SuccessBackground else AppColors.ErrorBackground)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(accent)
        )
        Column(Modifier.padding(20.dp)) {
            Text(
                if (feedback.correct) "✓ ${praise(feedback)}" else "✗ Niepoprawnie",
                color = accent,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Monospace,
                fontSize = 20.sp,
            )
            if (!feedback.correct) {
                Spacer(Modifier.height(10.dp))
                Text("Poprawna odpowiedź:", color = AppColors.TextDim, fontSize = 14.sp)
                Spacer(Modifier.height(2.dp))
                CodeText(feedback.correctAnswer, color = AppColors.Text)
            }
            Spacer(Modifier.height(10.dp))
            Text(
                "# ${feedback.explanation}",
                color = AppColors.TextDim,
                fontSize = 14.sp,
                fontFamily = FontFamily.Monospace,
                lineHeight = 20.sp,
            )
            Spacer(Modifier.height(16.dp))
            PrimaryButton(
                text = if (feedback.correct) "Dalej  →" else "Rozumiem  →",
                onClick = onContinue,
                color = accent,
                contentColor = AppColors.Background,
            )
        }
    }
}

private val praises = listOf("Świetnie!", "Dokładnie tak!", "Brawo!", "Tak trzymaj!", "Działa!")

private fun praise(feedback: Feedback) = praises[Math.floorMod(feedback.explanation.hashCode(), praises.size)]
