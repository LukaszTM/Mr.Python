package com.mrpython.app.ui.screens

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.horizontalScroll
import androidx.compose.ui.draw.alpha
import com.mrpython.app.ads.AdsManager
import com.mrpython.app.domain.AccessorySlot
import com.mrpython.app.domain.Avatar
import com.mrpython.app.domain.Avatars
import com.mrpython.app.domain.Language
import com.mrpython.app.domain.SnakeSkin
import com.mrpython.app.domain.Tier
import com.mrpython.app.domain.t
import com.mrpython.app.notifications.ReminderScheduler
import com.mrpython.app.ui.components.SnakeAvatar
import com.mrpython.app.widget.StreakWidget
import com.mrpython.app.ui.components.darker
import com.mrpython.app.ui.components.raised

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
fun ProfileScreen(
    state: AppUiState,
    onReset: () -> Unit,
    onRemindersEnabled: (Boolean) -> Unit,
    onReminderHour: (Int) -> Unit,
    onAvatar: (Avatar) -> Unit,
    onShowPaywall: () -> Unit = {},
    onLanguage: (Language) -> Unit = {},
    onAvatarLocked: () -> Unit = {},
) {
    val p = state.progress
    var confirmReset by remember { mutableStateOf(false) }
    var editingAvatar by remember { mutableStateOf(false) }
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
                .size(140.dp)
                .clip(CircleShape)
                .background(AppColors.SurfaceHigh)
                .border(4.dp, p.leagueTier.color(), CircleShape),
            contentAlignment = Alignment.Center,
        ) { SnakeAvatar(p.avatar, 120.dp) }
        Spacer(Modifier.height(12.dp))
        Text("Mr. Python", fontSize = 26.sp, fontWeight = FontWeight.Bold, color = AppColors.Text)
        Text(p.leagueTier.title, color = p.leagueTier.color(), fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("import wiedza  # uczę się Pythona".t(), color = AppColors.TextDim, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
        Spacer(Modifier.height(14.dp))
        // The wardrobe stays folded away until asked for, right under the avatar it changes.
        SecondaryButton(
            text = if (editingAvatar) "✓  Gotowe".t() else "✎  Edytuj awatara".t(),
            onClick = { editingAvatar = !editingAvatar },
            color = if (editingAvatar) AppColors.Success else AppColors.Yellow,
        )
        AnimatedVisibility(visible = editingAvatar) {
            Column {
                Spacer(Modifier.height(16.dp))
                if (!state.fullCourse) {
                    Text(
                        "🔒 Kolor węża zmienisz za darmo. Akcesoria są w pełnej wersji.".t(),
                        Modifier.fillMaxWidth().padding(bottom = 10.dp),
                        color = AppColors.Yellow,
                        fontSize = 14.sp,
                    )
                }
                AvatarEditor(p.avatar, p.leagueTier, onAvatar)
            }
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Statystyki".t())
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("🔥", "${Rules.visibleStreak(p, state.today)}", "Dni serii".t(), Modifier.weight(1f))
            StatCard("⚡", "${p.totalXp}", "Łącznie XP".t(), Modifier.weight(1f))
        }
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            StatCard("📚", "$done/$totalLessons", "Lekcje".t(), Modifier.weight(1f))
            StatCard("♥", if (state.fullCourse) "∞" else "${p.hearts}/${Rules.MAX_HEARTS}", "Serca".t(), Modifier.weight(1f))
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Przypomnienia".t())
        ReminderSettings(state, onRemindersEnabled, onReminderHour)
        val widgetContext = LocalContext.current
        if (StreakWidget.canPin(widgetContext)) {
            Spacer(Modifier.height(12.dp))
            SecondaryButton(
                text = "▦  Dodaj widżet na ekran główny".t(),
                onClick = { StreakWidget.requestPin(widgetContext) },
                color = AppColors.BlueBright,
            )
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Język".t())
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Language.entries.forEach { language ->
                SecondaryButton(
                    text = language.label,
                    onClick = { onLanguage(language) },
                    modifier = Modifier.weight(1f),
                    color = if (language == state.language) AppColors.Yellow else AppColors.TextDim,
                )
            }
        }
        Spacer(Modifier.height(24.dp))

        // Where consent for ads is required by law, it can also be changed later.
        val adsActivity = widgetContext as? Activity
        if (!state.fullCourse && adsActivity != null && AdsManager.privacyOptionsRequired(adsActivity)) {
            SecondaryButton(
                text = "Ustawienia prywatności reklam".t(),
                onClick = { AdsManager.showPrivacyOptions(adsActivity) },
                color = AppColors.TextDim,
            )
            Spacer(Modifier.height(24.dp))
        }

        SectionTitle("Pełna wersja".t())
        if (state.fullCourse) {
            Text(
                "✓ Odblokowana. Dziękujemy za wsparcie!".t(),
                Modifier.fillMaxWidth(),
                color = AppColors.Success,
                fontWeight = FontWeight.SemiBold,
            )
        } else {
            SecondaryButton(text = "🔒  Odblokuj pełną wersję".t(), onClick = onShowPaywall, color = AppColors.Yellow)
        }
        Spacer(Modifier.height(24.dp))

        SectionTitle("Postęp kursu".t())
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
            text = "Zresetuj postęp".t(),
            onClick = { confirmReset = true },
            color = AppColors.Error,
        )
    }

    if (confirmReset) {
        AlertDialog(
            onDismissRequest = { confirmReset = false },
            title = { Text("Zresetować postęp?".t()) },
            text = { Text("Stracisz wszystkie XP, serię i ukończone lekcje. Tego nie da się cofnąć.".t()) },
            confirmButton = {
                TextButton(onClick = { confirmReset = false; onReset() }) {
                    Text("Resetuj".t(), color = AppColors.Error, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { confirmReset = false }) { Text("Anuluj".t(), color = AppColors.Yellow) }
            },
            containerColor = AppColors.Surface,
            titleContentColor = AppColors.Text,
            textContentColor = AppColors.TextDim,
        )
    }
}

/** Pick a snake and one accessory per slot; locked items show the tier that unlocks them. */
@Composable
private fun AvatarEditor(avatar: Avatar, tier: Tier, onAvatar: (Avatar) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        AvatarRowLabel("Wąż".t())
        Row(
            Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            SnakeSkin.entries.forEach { skin ->
                AvatarTile(
                    preview = Avatar(skin),
                    title = skin.title,
                    selected = avatar.skin == skin,
                    lockedUntil = skin.requiredTier.takeIf { !Avatars.isUnlocked(skin, tier) },
                    onClick = { onAvatar(avatar.copy(skin = skin)) },
                )
            }
        }
        AccessorySlot.entries.forEach { slot ->
            Spacer(Modifier.height(14.dp))
            AvatarRowLabel(slot.title)
            Row(
                Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                AvatarTile(
                    preview = Avatar(avatar.skin),
                    title = "Brak".t(),
                    selected = avatar.accessory(slot) == null,
                    lockedUntil = null,
                    onClick = { onAvatar(avatar.with(slot, null)) },
                )
                Avatars.accessories(slot).forEach { item ->
                    AvatarTile(
                        preview = Avatar(avatar.skin).with(slot, item),
                        title = item.title,
                        selected = avatar.accessory(slot) == item,
                        lockedUntil = item.requiredTier.takeIf { !Avatars.isUnlocked(item, tier) },
                        onClick = { onAvatar(avatar.with(slot, item)) },
                    )
                }
            }
        }
    }
}

@Composable
private fun AvatarRowLabel(text: String) {
    Text(
        text,
        Modifier.padding(bottom = 8.dp),
        color = AppColors.Text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 15.sp,
    )
}

/** One choice in the avatar editor: a preview, its name and a lock when not yet unlocked. */
@Composable
private fun AvatarTile(
    preview: Avatar,
    title: String,
    selected: Boolean,
    lockedUntil: Tier?,
    onClick: () -> Unit,
) {
    val shape = RoundedCornerShape(14.dp)
    val locked = lockedUntil != null
    Column(
        Modifier
            .width(96.dp)
            .raised(if (selected) AppColors.Yellow.darker(0.5f) else AppColors.Edge, 4.dp)
            .clip(shape)
            .background(if (selected) AppColors.Yellow.copy(alpha = 0.14f) else AppColors.SurfaceHigh)
            .border(2.dp, if (selected) AppColors.Yellow else AppColors.Border, shape)
            .clickable(enabled = !locked, onClick = onClick)
            .padding(horizontal = 6.dp, vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(contentAlignment = Alignment.Center) {
            SnakeAvatar(preview, 64.dp, Modifier.alpha(if (locked) 0.3f else 1f))
            if (locked) Text("🔒", fontSize = 22.sp)
        }
        Spacer(Modifier.height(4.dp))
        Text(
            title,
            color = if (locked) AppColors.TextFaint else AppColors.Text,
            fontSize = 11.sp,
            lineHeight = 13.sp,
            textAlign = TextAlign.Center,
            maxLines = 2,
            minLines = 2,
        )
        if (lockedUntil != null) {
            Text(
                lockedUntil.title.substringBefore(" "),
                color = lockedUntil.color(),
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
            )
        } else {
            Text(if (selected) "✓ wybrane".t() else " ", color = AppColors.Yellow, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
    }
}

/** Daily reminder switch and hour; asks for the notification permission when needed. */
@Composable
private fun ReminderSettings(
    state: AppUiState,
    onEnabled: (Boolean) -> Unit,
    onHour: (Int) -> Unit,
) {
    val context = LocalContext.current
    val permission = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { }
    // Re-read on every recomposition (the screen refreshes each second), so it follows system settings.
    val blocked = state.remindersEnabled && !ReminderScheduler.canNotify(context)
    val shape = RoundedCornerShape(14.dp)
    Column(
        Modifier
            .fillMaxWidth()
            .raised(AppColors.Edge, 4.dp)
            .clip(shape)
            .background(AppColors.SurfaceHigh)
            .border(1.5.dp, AppColors.Border, shape)
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text("🔔 Codzienne przypomnienie".t(), color = AppColors.Text, fontWeight = FontWeight.Bold)
                Text(
                    "Powiadomienie, gdy nie było jeszcze dziś lekcji, i ostrzeżenie o 22:00, gdy seria jest zagrożona.".t(),
                    color = AppColors.TextDim,
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                )
            }
            Spacer(Modifier.width(8.dp))
            Switch(
                checked = state.remindersEnabled,
                onCheckedChange = { enabled ->
                    onEnabled(enabled)
                    if (enabled && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                        !ReminderScheduler.canNotify(context)
                    ) {
                        permission.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = AppColors.OnYellow,
                    checkedTrackColor = AppColors.Yellow,
                    uncheckedThumbColor = AppColors.TextDim,
                    uncheckedTrackColor = AppColors.Surface,
                    uncheckedBorderColor = AppColors.Border,
                ),
            )
        }
        if (state.remindersEnabled) {
            Spacer(Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Godzina".t(), Modifier.weight(1f), color = AppColors.Text, fontWeight = FontWeight.SemiBold)
                HourButton("−") { onHour(Math.floorMod(state.reminderHour - 1, 24)) }
                Text(
                    "%02d:00".format(state.reminderHour),
                    Modifier.width(76.dp),
                    color = AppColors.Yellow,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
                HourButton("+") { onHour(Math.floorMod(state.reminderHour + 1, 24)) }
            }
        }
        if (blocked) {
            Spacer(Modifier.height(12.dp))
            Text(
                "Powiadomienia są zablokowane w ustawieniach telefonu, więc przypomnienia się nie pokażą.".t(),
                color = AppColors.Error,
                fontSize = 13.sp,
                lineHeight = 17.sp,
            )
            Spacer(Modifier.height(8.dp))
            SecondaryButton(
                text = "Otwórz ustawienia powiadomień".t(),
                onClick = {
                    // Some phones have no such screen; then the button simply does nothing.
                    runCatching {
                        context.startActivity(
                            Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS)
                                .putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        )
                    }
                },
            )
        }
    }
}

@Composable
private fun HourButton(label: String, onClick: () -> Unit) {
    val shape = RoundedCornerShape(10.dp)
    Box(
        Modifier
            .raised(AppColors.Edge, 3.dp, radius = 10.dp)
            .size(40.dp)
            .clip(shape)
            .background(AppColors.Surface)
            .border(1.5.dp, AppColors.Border, shape)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) { Text(label, color = AppColors.Text, fontWeight = FontWeight.Bold, fontSize = 20.sp) }
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
    val shape = RoundedCornerShape(14.dp)
    Row(
        modifier
            .raised(AppColors.Edge, 4.dp)
            .clip(shape)
            .background(AppColors.SurfaceHigh)
            .border(1.5.dp, AppColors.Border, shape)
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
