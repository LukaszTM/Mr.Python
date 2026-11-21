package com.mrpython.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.mrpython.app.data.CourseContent
import com.mrpython.app.domain.Paywall
import com.mrpython.app.domain.t
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.theme.AppColors

/** Offers the one-time purchase that opens every module after the free ones. */
@Composable
fun PaywallDialog(state: AppUiState, onBuy: () -> Unit, onRestore: () -> Unit, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        val shape = RoundedCornerShape(16.dp)
        Column(
            Modifier
                .fillMaxWidth()
                .clip(shape)
                .background(AppColors.Surface)
                .border(1.dp, AppColors.Border, shape)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                "pip install pelny-kurs".t(),
                color = AppColors.TextFaint,
                fontFamily = FontFamily.Monospace,
                fontSize = 13.sp,
            )
            Spacer(Modifier.height(6.dp))
            Text("Pełny kurs Pythona".t(), color = AppColors.Text, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            Spacer(Modifier.height(12.dp))
            val modules = CourseContent.units.size - Paywall.FREE_UNITS
            val lessons = Paywall.paidLessons(CourseContent.units)
            listOf(
                "{0} kolejnych modułów i {1} lekcji".t(modules, lessons),
                "funkcje, klasy, pliki, wyjątki i więcej".t(),
                "serca bez limitu i żadnych reklam".t(),
                "płacisz raz, bez subskrypcji".t(),
                "zakup jest przypisany do Twojego konta Google".t(),
            ).forEach { line ->
                Text(
                    "✓ $line",
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp),
                    color = AppColors.Text,
                    lineHeight = 20.sp,
                )
            }
            Spacer(Modifier.height(18.dp))
            val price = state.fullCoursePrice
            PrimaryButton(
                text = when {
                    price != null -> "Kup za {0}".t(price)
                    state.testBuild -> "Odblokuj (wersja testowa, bez płatności)".t()
                    else -> "Kup pełny kurs".t()
                },
                onClick = onBuy,
            )
            state.purchaseMessage?.let { message ->
                Spacer(Modifier.height(10.dp))
                Text(message, color = AppColors.Streak, textAlign = TextAlign.Center, fontSize = 14.sp, lineHeight = 19.sp)
            }
            Spacer(Modifier.height(4.dp))
            TextButton(onClick = onRestore) { Text("Przywróć zakup".t(), color = AppColors.BlueBright) }
            TextButton(onClick = onDismiss) { Text("Nie teraz".t(), color = AppColors.TextDim) }
        }
    }
}
