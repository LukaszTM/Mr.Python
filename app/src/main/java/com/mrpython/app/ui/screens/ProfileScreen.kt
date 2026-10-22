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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Rules
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.ChunkyButton
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
                .background(Color(0xFFFFE873))
                .border(4.dp, Color(0xFF3776AB), CircleShape),
            contentAlignment = Alignment.Center,
        ) { Text("🐍", fontSize = 56.sp) }
        Spacer(Modifier.height(12.dp))
        Text("Mr. Python", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold, color = AppColors.Text)
        Text("Uczę się Pythona", color = AppColors.TextLight)
        Spacer(Modifier.height(24.dp))

        SectionTitle("Statystyki")
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("🔥", "${Rules.visibleStreak(p, state.today)}", "Dni serii", Modifier.weight(1f))
            StatCard("⚡", "${p.totalXp}", "Łącznie XP", Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("📚", "$done/$totalLessons", "Lekcje", Modifier.weight(1f))
            StatCard("❤️", "${p.hearts}/${Rules.MAX_HEARTS}", "Serca", Modifier.weight(1f))
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Postęp kursu")
        CourseContent.units.forEachIndexed { i, unit ->
            val unitDone = unit.lessons.count { it.id in p.completedLessons }
            val color = AppColors.unitColors[i % AppColors.unitColors.size].first
            Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Row {
                    Text(unit.title, fontWeight = FontWeight.Bold, color = AppColors.Text)
                    Spacer(Modifier.weight(1f))
                    Text("$unitDone/${unit.lessons.size}", color = AppColors.TextLight)
                }
                Spacer(Modifier.height(6.dp))
                ProgressBar(unitDone.toFloat() / unit.lessons.size, Modifier.fillMaxWidth(), color = color, height = 12.dp)
            }
        }
        Spacer(Modifier.height(32.dp))
        ChunkyButton(
            text = "Zresetuj postęp",
            onClick = { confirmReset = true },
            color = Color.White,
            shadowColor = AppColors.Gray,
            textColor = AppColors.Red,
        )
    }

    if (confirmReset) {
        AlertDialog(
            onDismissRequest = { confirmReset = false },
            title = { Text("Zresetować postęp?") },
            text = { Text("Stracisz wszystkie XP, serię i ukończone lekcje. Tego nie da się cofnąć.") },
            confirmButton = {
                TextButton(onClick = { confirmReset = false; onReset() }) {
                    Text("Resetuj", color = AppColors.Red, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmReset = false }) { Text("Anuluj") }
            },
            containerColor = Color.White,
        )
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text,
        Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        fontSize = 20.sp,
        fontWeight = FontWeight.ExtraBold,
        color = AppColors.Text,
    )
}

@Composable
private fun StatCard(icon: String, value: String, label: String, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(14.dp)
    Row(
        modifier
            .border(2.dp, AppColors.Gray, shape)
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(icon, fontSize = 24.sp)
        Spacer(Modifier.width(10.dp))
        Column {
            Text(value, fontWeight = FontWeight.ExtraBold, fontSize = 18.sp, color = AppColors.Text)
            Text(label, color = AppColors.TextLight, fontSize = 13.sp)
        }
    }
}
