package com.mrpython.app

import android.Manifest
import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Brush
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.SystemBarStyle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrpython.app.ads.AdsManager
import com.mrpython.app.domain.Rules
import com.mrpython.app.domain.t
import com.mrpython.app.ui.AppViewModel
import com.mrpython.app.ui.Tab
import com.mrpython.app.ui.screens.HomeScreen
import com.mrpython.app.ui.screens.LeagueScreen
import com.mrpython.app.ui.screens.LessonCompleteScreen
import com.mrpython.app.ui.screens.LessonScreen
import com.mrpython.app.ui.screens.OutOfHeartsDialog
import com.mrpython.app.ui.screens.PaywallDialog
import com.mrpython.app.ui.screens.ProfileScreen
import com.mrpython.app.ui.screens.WeekResultDialog
import com.mrpython.app.ui.theme.AppColors
import com.mrpython.app.ui.theme.MrPythonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val background = AppColors.Background.toArgb()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(background),
            navigationBarStyle = SystemBarStyle.dark(background),
        )
        setContent {
            MrPythonTheme { MrPythonApp() }
        }
    }
}

@Composable
fun MrPythonApp(viewModel: AppViewModel = viewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    // Like Duolingo, ask for notifications right after the first finished lesson (Android 13+).
    val notificationPermission = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { }
    val lessonFinished = state.result != null
    LaunchedEffect(lessonFinished) {
        if (lessonFinished && Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
            viewModel.shouldAskForNotificationPermission()
        ) {
            notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    // Ads are only for the free version; buying the full course switches them off for good.
    val activity = LocalContext.current as? Activity
    val showAds = !state.fullCourse
    LaunchedEffect(showAds, activity) {
        if (showAds && activity != null) AdsManager.start(activity)
    }

    // A new language rebuilds every screen, so no text of the old one stays behind.
    key(state.language) {
    Box(
        Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .background(Brush.verticalGradient(listOf(Color(0xFF16233A), AppColors.Background)))
            .safeDrawingPadding()
    ) {
        val lesson = state.lesson
        val result = state.result
        when {
            lesson != null -> LessonScreen(
                lesson = lesson,
                hearts = if (state.fullCourse) null else state.progress.hearts,
                xpMultiplier = state.event?.multiplier,
                onSubmit = viewModel::submit,
                onContinue = viewModel::continueLesson,
                onQuit = viewModel::quitLesson,
            )
            result != null -> LessonCompleteScreen(
                result,
                hearts = if (state.fullCourse) Rules.MAX_HEARTS else state.progress.hearts,
                onTakeHearts = viewModel::takeHeartsInsteadOfBonus,
                onContinue = {
                    if (showAds) AdsManager.showThen(activity, viewModel::dismissResult) else viewModel.dismissResult()
                },
            )
            else -> Column(Modifier.fillMaxSize()) {
                Box(Modifier.weight(1f)) {
                    when (state.tab) {
                        Tab.LEARN -> HomeScreen(
                            state,
                            onStartLesson = viewModel::startLesson,
                            onShowPaywall = viewModel::showPaywall,
                        )
                        Tab.LEAGUE -> LeagueScreen(state)
                        Tab.PROFILE -> ProfileScreen(
                            state,
                            onReset = viewModel::resetProgress,
                            onRemindersEnabled = viewModel::setRemindersEnabled,
                            onReminderHour = viewModel::setReminderHour,
                            onAvatar = viewModel::setAvatar,
                            onShowPaywall = viewModel::showPaywall,
                            onLanguage = viewModel::setLanguage,
                            onAvatarLocked = viewModel::showAvatarPaywall,
                        )
                    }
                }
                BottomBar(state.tab, onSelect = viewModel::selectTab)
            }
        }

        if (state.outOfHearts) {
            OutOfHeartsDialog(
                state.progress,
                state.nowMillis,
                onDismiss = viewModel::dismissOutOfHearts,
                buyLabel = when {
                    state.heartsPrice != null -> "♥  Kup pełne serca za {0}".t(state.heartsPrice)
                    state.testBuild -> "♥  Pełne serca (wersja testowa, bez płatności)".t()
                    else -> "♥  Kup pełne serca".t()
                },
                message = state.purchaseMessage,
                onBuy = { activity?.let(viewModel::buyHearts) },
            )
        }

        if (state.paywall && lesson == null) {
            PaywallDialog(
                state = state,
                onBuy = { activity?.let(viewModel::buyFullCourse) },
                onRestore = viewModel::restorePurchase,
                onDismiss = viewModel::dismissPaywall,
            )
        }

        val weekResult = state.progress.pendingWeekResult
        if (weekResult != null && lesson == null) {
            WeekResultDialog(weekResult, onDismiss = viewModel::dismissWeekResult)
        }
    }
    }
}

@Composable
private fun BottomBar(selected: Tab, onSelect: (Tab) -> Unit) {
    Column(Modifier.background(AppColors.Surface)) {
        HorizontalDivider(color = AppColors.Border, thickness = 2.dp)
        Row(Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 6.dp)) {
            BottomBarItem("</>", "Nauka".t(), selected == Tab.LEARN, Modifier.weight(1f)) { onSelect(Tab.LEARN) }
            BottomBarItem("#1", "Liga".t(), selected == Tab.LEAGUE, Modifier.weight(1f)) { onSelect(Tab.LEAGUE) }
            BottomBarItem("~/", "Profil".t(), selected == Tab.PROFILE, Modifier.weight(1f)) { onSelect(Tab.PROFILE) }
        }
    }
}

@Composable
private fun BottomBarItem(icon: String, label: String, active: Boolean, modifier: Modifier, onClick: () -> Unit) {
    val shape = RoundedCornerShape(12.dp)
    Column(
        modifier
            .padding(horizontal = 4.dp)
            .clip(shape)
            .background(if (active) AppColors.Yellow.copy(alpha = 0.14f) else Color.Transparent)
            .border(2.dp, if (active) AppColors.Yellow.copy(alpha = 0.7f) else Color.Transparent, shape)
            .clickable(onClick = onClick)
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val color = if (active) AppColors.Yellow else AppColors.TextFaint
        Text(icon, fontSize = 18.sp, color = color, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        Text(label, color = color, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
    }
}
