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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.domain.Progress
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.LessonResult
import com.mrpython.app.ui.components.BigEmoji
import com.mrpython.app.ui.components.ChunkyButton
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
        BigEmoji(if (result.accuracyPercent == 100) "🏆" else "🎉", size = 96)
        Spacer(Modifier.height(16.dp))
        Text(
            if (result.isPractice) "Powtórka zaliczona!" else "Lekcja ukończona!",
            fontSize = 28.sp,
            fontWeight = FontWeight.ExtraBold,
            color = AppColors.Yellow,
            textAlign = TextAlign.Center,
        )
        if (result.isPractice) {
            Spacer(Modifier.height(4.dp))
            Text("Odzyskujesz jedno ❤️", color = AppColors.TextLight, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            ResultCard("ZDOBYTE XP", "⚡ ${result.xpEarned}", AppColors.Yellow, Modifier.weight(1f))
            ResultCard("DOKŁADNOŚĆ", "🎯 ${result.accuracyPercent}%", AppColors.Green, Modifier.weight(1f))
            ResultCard("SERIA", "🔥 ${result.streak}", AppColors.Orange, Modifier.weight(1f))
        }
        Spacer(Modifier.weight(1f))
        ChunkyButton("Dalej", onClick = onContinue)
    }
}

@Composable
private fun ResultCard(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(14.dp)
    Column(
        modifier
            .clip(shape)
            .background(color)
            .border(2.dp, color, shape),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            label,
            Modifier.padding(vertical = 6.dp),
            color = Color.White,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 12.sp,
        )
        Text(
            value,
            Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(Color.White)
                .padding(vertical = 14.dp),
            color = color,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun OutOfHeartsDialog(progress: Progress, nowMillis: Long, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BigEmoji("💔", size = 64)
            Spacer(Modifier.height(8.dp))
            Text("Brak serc!", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = AppColors.Text)
            Spacer(Modifier.height(8.dp))
            val wait = Rules.millisToNextHeart(progress, nowMillis)
            val timer = wait?.let {
                val seconds = it / 1000
                "Następne serce za %d:%02d.".format(seconds / 60, seconds % 60)
            } ?: "Twoje serca są już pełne!"
            Text(
                "$timer\nMożesz też powtórzyć ukończoną lekcję – nie kosztuje serc, a da Ci jedno ❤️.",
                color = AppColors.TextLight,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(20.dp))
            ChunkyButton("OK", onClick = onDismiss, color = AppColors.Blue, shadowColor = AppColors.BlueDark)
        }
    }
}
