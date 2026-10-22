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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
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
import com.mrpython.app.domain.League
import com.mrpython.app.domain.Standing
import com.mrpython.app.domain.Tier
import com.mrpython.app.domain.WeekResult
import com.mrpython.app.ui.AppUiState
import com.mrpython.app.ui.components.BigEmoji
import com.mrpython.app.ui.components.PrimaryButton
import com.mrpython.app.ui.theme.AppColors
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.temporal.ChronoUnit

/** Colour of each career tier, from intern to CTO. */
private val tierColors = listOf(
    Color(0xFF8A9AB0),
    Color(0xFF3FB950),
    Color(0xFF4B8BBE),
    Color(0xFFA78BFA),
    Color(0xFFF0883E),
    Color(0xFF2DD4BF),
    Color(0xFFFFD43B),
)

fun Tier.color(): Color = tierColors[ordinal]

@Composable
fun LeagueScreen(state: AppUiState) {
    val p = state.progress
    val tier = p.leagueTier
    val weekStart = League.weekStart(state.today)
    val now = LocalDateTime.ofInstant(Instant.ofEpochMilli(state.nowMillis), ZoneId.systemDefault())
    val table = League.standings(weekStart, tier, p.weekXp, League.weekFraction(now, weekStart))

    LazyColumn(Modifier.fillMaxSize()) {
        item { LeagueHeader(tier, weekStart, now) }
        items(table, key = { it.name }) { row ->
            StandingRow(row, tier)
            if (row.rank == League.PROMOTION_SLOTS && tier.next != null) PromotionLine(tier.next!!)
        }
        item { Spacer(Modifier.height(24.dp)) }
    }
}

@Composable
private fun LeagueHeader(tier: Tier, weekStart: LocalDate, now: LocalDateTime) {
    Column(Modifier.padding(16.dp)) {
        Text(
            "LIGA TYGODNIOWA",
            color = AppColors.TextFaint,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            letterSpacing = 1.sp,
        )
        Spacer(Modifier.height(4.dp))
        Text(tier.title, color = tier.color(), fontWeight = FontWeight.Bold, fontSize = 28.sp)
        Spacer(Modifier.height(12.dp))
        CareerLadder(tier)
        Spacer(Modifier.height(14.dp))
        val left = ChronoUnit.MINUTES.between(now, weekStart.plusWeeks(1).atStartOfDay()).coerceAtLeast(0)
        val days = left / (24 * 60)
        val hours = (left / 60) % 24
        Text(
            "# koniec tygodnia za ${if (days > 0) "$days d " else ""}$hours h",
            color = AppColors.TextDim,
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
        )
        val next = tier.next
        Text(
            if (next != null) {
                "Trzy pierwsze miejsca awansują na: ${next.title}"
            } else {
                "Jesteś na szczycie kariery. Broń swojej pozycji!"
            },
            color = AppColors.Text,
            fontSize = 15.sp,
        )
    }
    HorizontalDivider(color = AppColors.Border, thickness = 1.dp)
}

/** Seven dots from intern to CTO, with the current tier highlighted. */
@Composable
private fun CareerLadder(current: Tier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Tier.entries.forEachIndexed { i, tier ->
            val reached = tier.ordinal <= current.ordinal
            Box(
                Modifier
                    .size(if (tier == current) 16.dp else 10.dp)
                    .clip(CircleShape)
                    .background(if (reached) tier.color() else AppColors.SurfaceHigh)
            )
            if (i < Tier.entries.lastIndex) {
                Box(
                    Modifier
                        .width(22.dp)
                        .height(2.dp)
                        .background(if (tier.ordinal < current.ordinal) tier.color() else AppColors.SurfaceHigh)
                )
            }
        }
    }
}

@Composable
private fun StandingRow(row: Standing, tier: Tier) {
    val promoted = row.rank <= League.PROMOTION_SLOTS && tier.next != null
    val shape = RoundedCornerShape(10.dp)
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 3.dp)
            .clip(shape)
            .background(if (row.isPlayer) AppColors.Yellow.copy(alpha = 0.12f) else Color.Transparent)
            .border(1.dp, if (row.isPlayer) AppColors.Yellow else Color.Transparent, shape)
            .padding(horizontal = 12.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "${row.rank}",
            Modifier.width(28.dp),
            color = if (promoted) AppColors.Success else AppColors.TextDim,
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Bold,
        )
        Box(
            Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(if (row.isPlayer) AppColors.Yellow else AppColors.SurfaceHigh),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                if (row.isPlayer) "🐍" else row.name.first().uppercase(),
                color = AppColors.Text,
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.width(12.dp))
        Text(
            row.name,
            Modifier.weight(1f),
            color = AppColors.Text,
            fontWeight = if (row.isPlayer) FontWeight.Bold else FontWeight.Normal,
        )
        Text(
            "${row.xp} XP",
            color = if (row.isPlayer) AppColors.Yellow else AppColors.TextDim,
            fontFamily = FontFamily.Monospace,
            fontSize = 14.sp,
        )
    }
}

@Composable
private fun PromotionLine(next: Tier) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .background(AppColors.Success)
        )
        Text(
            "▲ awans: ${next.title}",
            color = AppColors.Success,
            fontFamily = FontFamily.Monospace,
            fontSize = 12.sp,
        )
        Box(
            Modifier
                .weight(1f)
                .height(1.dp)
                .background(AppColors.Success)
        )
    }
}

/** Shown once after a league week ends. */
@Composable
fun WeekResultDialog(result: WeekResult, onDismiss: () -> Unit) {
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
            val promoted = result.promotedTo
            BigEmoji(if (promoted != null) "🚀" else "📊", size = 64)
            Spacer(Modifier.height(12.dp))
            Text(
                if (promoted != null) "Awans!" else "Tydzień zakończony",
                color = AppColors.Text,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Twoje miejsce w lidze: ${result.rank}.",
                color = AppColors.TextDim,
                textAlign = TextAlign.Center,
            )
            if (promoted != null) {
                Spacer(Modifier.height(4.dp))
                Text("Nowe stanowisko:", color = AppColors.TextDim)
                Text(promoted.title, color = promoted.color(), fontWeight = FontWeight.Bold, fontSize = 22.sp)
            } else {
                Spacer(Modifier.height(4.dp))
                Text(
                    "Do awansu potrzeba miejsca w pierwszej trójce. Powodzenia w tym tygodniu!",
                    color = AppColors.TextDim,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(Modifier.height(20.dp))
            PrimaryButton("Dalej  →", onClick = onDismiss)
        }
    }
}
