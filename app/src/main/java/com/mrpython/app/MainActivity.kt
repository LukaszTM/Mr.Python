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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mrpython.app.ui.AppViewModel
import com.mrpython.app.ui.Tab
import com.mrpython.app.ui.screens.HomeScreen
import com.mrpython.app.ui.screens.LessonCompleteScreen
import com.mrpython.app.ui.screens.LessonScreen
import com.mrpython.app.ui.screens.OutOfHeartsDialog
import com.mrpython.app.ui.screens.ProfileScreen
import com.mrpython.app.ui.theme.AppColors
import com.mrpython.app.ui.theme.MrPythonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val white = Color.White.toArgb()
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(white, white),
            navigationBarStyle = SystemBarStyle.light(white, white),
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
            .background(Color.White)
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
                        Tab.PROFILE -> ProfileScreen(state, onReset = viewModel::resetProgress)
                    }
                }
                BottomBar(state.tab, onSelect = viewModel::selectTab)
            }
        }

        if (state.outOfHearts) {
            OutOfHeartsDialog(state.progress, state.nowMillis, onDismiss = viewModel::dismissOutOfHearts)
        }
    }
}

@Composable
private fun BottomBar(selected: Tab, onSelect: (Tab) -> Unit) {
    Column {
        HorizontalDivider(color = AppColors.Gray, thickness = 2.dp)
        Row(Modifier.fillMaxWidth().padding(8.dp)) {
            BottomBarItem("🏠", "Nauka", selected == Tab.LEARN, Modifier.weight(1f)) { onSelect(Tab.LEARN) }
            BottomBarItem("👤", "Profil", selected == Tab.PROFILE, Modifier.weight(1f)) { onSelect(Tab.PROFILE) }
        }
    }
}

@Composable
private fun BottomBarItem(icon: String, label: String, active: Boolean, modifier: Modifier, onClick: () -> Unit) {
    Column(
        modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (active) AppColors.BlueLight else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(vertical = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(icon, fontSize = 22.sp)
        Text(
            label,
            color = if (active) AppColors.Blue else AppColors.GrayDark,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 12.sp,
        )
    }
}
