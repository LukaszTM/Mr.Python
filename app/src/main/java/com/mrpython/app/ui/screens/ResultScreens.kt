package com.mrpython.app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.LessonResult
import com.mrpython.app.ui.components.BigEmoji
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.components.SecondaryButton
import com.mrpython.app.ui.theme.AppColors

@Composable
fun LessonCompleteScreen(result: LessonResult, onContinue: () -> Unit) {
    BackHandler(onBack = onContinue)
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        BigEmoji(if (result.accuracyPercent == 100) "🏆" else "🐍", size = 88)
        Spacer(Modifier.height(16.dp))
        Text(
            "Process finished with exit code 0",
            color = AppColors.Success,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
        )
        Spacer(Modifier.height(6.dp))
        Text(
            if (result.isPractice) "Powtórka zaliczona!" else "Lekcja ukończona!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = AppColors.Text,
            textAlign = TextAlign.Center,
        )
        if (result.heartRestored) {
            Spacer(Modifier.height(4.dp))
            Text("Odzyskujesz jedno ♥", color = AppColors.Heart)
        }
        Spacer(Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            ResultCard("xp", "+${result.xpEarned}", AppColors.Yellow, Modifier.weight(1f))
            ResultCard("dokładność", "${result.accuracyPercent}%", AppColors.Success, Modifier.weight(1f))
            ResultCard("seria", "${result.streak} 🔥", AppColors.Streak, Modifier.weight(1f))
        }
        Spacer(Modifier.weight(1f))
        PrimaryButton("Dalej  →", onClick = onContinue)
    }
}

@Composable
private fun ResultCard(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(12.dp)
    Column(
        modifier
            .clip(shape)
            .background(AppColors.Surface)
            .border(1.dp, AppColors.Border, shape)
            .padding(vertical = 14.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(label, color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        Spacer(Modifier.height(4.dp))
        Text(value, color = color, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 20.sp)
    }
}

@Composable
fun OutOfHeartsDialog(progress: Progress, nowMillis: Long, onDismiss: () -> Unit) {
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
                "MemoryError: brak serc",
                color = AppColors.Error,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
            Spacer(Modifier.height(12.dp))
            val wait = Rules.millisToNextHeart(progress, nowMillis)
            val timer = wait?.let {
                val seconds = it / 1000
                "Następne ♥ za %d:%02d.".format(seconds / 60, seconds % 60)
            } ?: "Twoje serca są już pełne!"
            Text(timer, color = AppColors.Text, fontSize = 17.sp, fontWeight = FontWeight.SemiBold)
            Spacer(Modifier.height(6.dp))
            Text(
                "Możesz też powtórzyć ukończoną lekcję – nie kosztuje serc, a odda Ci jedno.",
                color = AppColors.TextDim,
                lineHeight = 20.sp,
            )
            Spacer(Modifier.height(20.dp))
            SecondaryButton("OK", onClick = onDismiss)
        }
    }
}
