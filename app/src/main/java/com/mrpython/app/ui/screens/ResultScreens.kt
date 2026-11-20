package com.mrpython.app.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import com.mrpython.app.ui.components.Confetti
import com.mrpython.app.ui.components.darker
import com.mrpython.app.ui.components.raised
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
    // Trophy pops in with a bounce, and the XP counts up from zero.
    val pop = remember { Animatable(0.3f) }
    var counting by remember { mutableStateOf(false) }
    val xp by animateIntAsState(if (counting) result.xpEarned else 0, tween(900), label = "xp")
    LaunchedEffect(Unit) {
        counting = true
        pop.animateTo(1f, spring(dampingRatio = 0.45f, stiffness = 200f))
    }
    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.weight(1f))
            Box(
                Modifier
                    .scale(pop.value)
                    .size(150.dp)
                    .clip(CircleShape)
                    .background(Brush.radialGradient(listOf(AppColors.Yellow.copy(alpha = 0.35f), Color.Transparent))),
                contentAlignment = Alignment.Center,
            ) { BigEmoji(if (result.accuracyPercent == 100) "🏆" else "🐍", size = 88) }
            Spacer(Modifier.height(12.dp))
            Text(
                if (result.isPractice) "Powtórka zaliczona!" else "Lekcja ukończona!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
                color = AppColors.Yellow,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(6.dp))
            Text(
                if (result.accuracyPercent == 100) "Bezbłędnie! Tak trzymaj." else "Dobra robota, kolejny krok za Tobą.",
                color = AppColors.TextDim,
                textAlign = TextAlign.Center,
            )
            if (result.heartRestored) {
                Spacer(Modifier.height(4.dp))
                Text("Odzyskujesz jedno ♥", color = AppColors.Heart, fontWeight = FontWeight.Bold)
            }
            result.event?.let { event ->
                Spacer(Modifier.height(14.dp))
                Text(
                    "⚡ ${event.title}: XP ×${event.multiplier}",
                    Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Brush.horizontalGradient(listOf(AppColors.EventStart, AppColors.EventEnd)))
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                )
            }
            Spacer(Modifier.height(28.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                ResultCard("ZDOBYTE XP", "⚡ $xp", AppColors.Yellow, Modifier.weight(1f))
                ResultCard("DOKŁADNOŚĆ", "${result.accuracyPercent}%", AppColors.Success, Modifier.weight(1f))
                ResultCard("SERIA", "🔥 ${result.streak}", AppColors.Streak, Modifier.weight(1f))
            }
            Spacer(Modifier.weight(1f))
            PrimaryButton("Dalej  →", onClick = onContinue)
        }
        Confetti()
    }
}

/** Coloured stat tile: a label strip on top and the value below. */
@Composable
private fun ResultCard(label: String, value: String, color: Color, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(14.dp)
    Column(
        modifier
            .raised(color.darker(0.45f), 5.dp)
            .clip(shape)
            .background(color),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            label,
            Modifier.padding(vertical = 6.dp),
            color = AppColors.Background,
            fontWeight = FontWeight.Black,
            fontSize = 11.sp,
            letterSpacing = 0.5.sp,
        )
        Text(
            value,
            Modifier
                .fillMaxWidth()
                .padding(start = 3.dp, end = 3.dp, bottom = 3.dp)
                .clip(RoundedCornerShape(11.dp))
                .background(AppColors.Surface)
                .padding(vertical = 14.dp),
            color = color,
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
        )
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
