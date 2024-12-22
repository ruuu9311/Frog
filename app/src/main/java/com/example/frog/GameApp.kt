package com.example.frog

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope

@Composable
fun GameApp(
    modifier: Modifier = Modifier,
    coroutineScope: CoroutineScope,
    screenW: Int,
    screenH: Int,
    scale: Float
) {
    var screen by remember { mutableStateOf("screenfirst") }
    var score by remember { mutableStateOf(0) }
    var btn1Count by remember { mutableStateOf(0) }
    var btn2Count by remember { mutableStateOf(0) }
    var touchedObjectsCount by remember { mutableStateOf(0) }

    when (screen) {
        "screenfirst" -> ScreenFirst(onStartClick = { screen = "screensecond" })
        "screensecond" -> ScreenSecond(
            onEnd = { screen = "screenthird" },
            onBtn1Click = {
                score += 1
                btn1Count += 1
            },
            onBtn2Click = {
                score += 1
                btn2Count += 1
            },
            onTouch = {
                score += 2
                touchedObjectsCount += 1
            },
            coroutineScope = coroutineScope,
            screenW = screenW
        )
        "screenthird" -> ScoreScreen(
            score = score,
            btn1Count = btn1Count,
            btn2Count = btn2Count,
            touchedObjectsCount = touchedObjectsCount,
            onRestartClick = {
                screen = "screenfirst"
                score = 0
                btn1Count = 0
                btn2Count = 0
                touchedObjectsCount = 0
            }
        )
    }
}