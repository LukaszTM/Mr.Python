package com.mrpython.app

import android.os.Bundle
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrpython.app.ui.AppViewModel
import com.mrpython.app.ui.Tab
import com.mrpython.app.ui.screens.HomeScreen
import com.mrpython.app.ui.screens.LeagueScreen
import com.mrpython.app.ui.screens.LessonCompleteScreen
import com.mrpython.app.ui.screens.LessonScreen
import com.mrpython.app.ui.screens.OutOfHeartsDialog
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

    Box(
        Modifier
            .fillMaxSize()
            .background(AppColors.Background)
            .safeDrawingPadding()
    ) {
        val lesson = state.lesson
        val result = state.result
        when {
            lesson != null -> LessonScreen(
                lesson = lesson,
                hearts = state.progress.hearts,
                onSubmit = viewModel::submit,
                onContinue = viewModel::continueLesson,
                onQuit = viewModel::quitLesson,
            )
            result != null -> LessonCompleteScreen(result, onContinue = viewModel::dismissResult)
            else -> Column(Modifier.fillMaxSize()) {
                Box(Modifier.weight(1f)) {
                    when (state.tab) {
                        Tab.LEARN -> HomeScreen(state, onStartLesson = viewModel::startLesson)
                        Tab.LEAGUE -> LeagueScreen(state)
                        Tab.PROFILE -> ProfileScreen(state, onReset = viewModel::resetProgress)
                    }
                }
                BottomBar(state.tab, onSelect = viewModel::selectTab)
            }
        }

        if (state.outOfHearts) {
            OutOfHeartsDialog(state.progress, state.nowMillis, onDismiss = viewModel::dismissOutOfHearts)
        }

        val weekResult = state.progress.pendingWeekResult
        if (weekResult != null && lesson == null) {
            WeekResultDialog(weekResult, onDismiss = viewModel::dismissWeekResult)
        }
    }
}

@Composable
private fun BottomBar(selected: Tab, onSelect: (Tab) -> Unit) {
    Column {
        HorizontalDivider(color = AppColors.Border, thickness = 1.dp)
        Row(Modifier.fillMaxWidth().padding(8.dp)) {
            BottomBarItem("</>", "Nauka", selected == Tab.LEARN, Modifier.weight(1f)) { onSelect(Tab.LEARN) }
            BottomBarItem("#1", "Liga", selected == Tab.LEAGUE, Modifier.weight(1f)) { onSelect(Tab.LEAGUE) }
            BottomBarItem("~/", "Profil", selected == Tab.PROFILE, Modifier.weight(1f)) { onSelect(Tab.PROFILE) }
        }
    }
}

@Composable
private fun BottomBarItem(icon: String, label: String, active: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Column(
        modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (active) AppColors.Surface else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val color = if (active) AppColors.Yellow else AppColors.TextFaint
        Text(icon, fontSize = 18.sp, color = color, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold)
        Text(label, color = color, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
    }
}
