package com.mrpython.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.SecondaryButton
import com.mrpython.app.ui.components.ProgressBar
import com.mrpython.app.ui.theme.AppColors

@Composable
fun ProfileScreen(state: AppUiState, onReset: () -> Unit) {
    val p = state.progress
    var confirmReset by remember { mutableStateOf(false) }
    val totalLessons = CourseContent.allLessons.size
    val done = CourseContent.allLessons.count { it.id in p.completedLessons }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            Modifier
                .size(110.dp)
                .clip(CircleShape)
                .background(AppColors.SurfaceHigh)
                .border(3.dp, AppColors.Yellow, CircleShape),
            contentAlignment = Alignment.Center,
        ) { Text("🐍", fontSize = 56.sp) }
        Spacer(Modifier.height(12.dp))
        Text("Mr. Python", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = AppColors.Text)
        Text(p.leagueTier.title, color = p.leagueTier.color(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("import wiedza  # uczę się Pythona", color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
        Spacer(Modifier.height(24.dp))

        SectionTitle("Statystyki")
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("🔥", "${Rules.visibleStreak(p, state.today)}", "Dni serii", Modifier.weight(1f))
            StatCard("⚡", "${p.totalXp}", "Łącznie XP", Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("📚", "$done/$totalLessons", "Lekcje", Modifier.weight(1f))
            StatCard("♥", "${p.hearts}/${Rules.MAX_HEARTS}", "Serca", Modifier.weight(1f))
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Postęp kursu")
        CourseContent.units.forEachIndexed { i, unit ->
            val unitDone = unit.lessons.count { it.id in p.completedLessons }
            val color = AppColors.unitColors[i % AppColors.unitColors.size]
            Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Row {
                    Text(unit.title, fontWeight = FontWeight.SemiBold, color = AppColors.Text)
                    Spacer(Modifier.weight(1f))
                    Text("$unitDone/${unit.lessons.size}", color = AppColors.TextDim, fontFamily = FontFamily.Monospace)
                }
                Spacer(Modifier.height(6.dp))
                ProgressBar(unitDone.toFloat() / unit.lessons.size, Modifier.fillMaxWidth(), color = color)
            }
        }
        Spacer(Modifier.height(32.dp))
        SecondaryButton(
            text = "Zresetuj postęp",
            onClick = { confirmReset = true },
            color = AppColors.Error,
        )
    }

    if (confirmReset) {
        AlertDialog(
            onDismissRequest = { confirmReset = false },
            title = { Text("Zresetować postęp?") },
            text = { Text("Stracisz wszystkie XP, serię i ukończone lekcje. Tego nie da się cofnąć.") },
            confirmButton = {
                TextButton(onClick = { confirmReset = false; onReset() }) {
                    Text("Resetuj", color = AppColors.Error, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmReset = false }) { Text("Anuluj", color = AppColors.Yellow) }
            },
            containerColor = AppColors.Surface,
            titleContentColor = AppColors.Text,
            textContentColor = AppColors.TextDim,
        )
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        "# $text",
        Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.Monospace,
        color = AppColors.TextDim,
    )
}

@Composable
private fun StatCard(icon: String, value: String, label: String, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(12.dp)
    Row(
        modifier
            .clip(shape)
            .background(AppColors.Surface)
            .border(1.dp, AppColors.Border, shape)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(icon, fontSize = 22.sp, color = AppColors.Heart)
        Spacer(Modifier.width(10.dp))
        Column {
            Text(value, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = AppColors.Text, fontFamily = FontFamily.Monospace)
            Text(label, color = AppColors.TextDim, fontSize = 13.sp)
        }
    }
}
