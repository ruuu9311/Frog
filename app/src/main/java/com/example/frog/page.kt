package com.example.frog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.layout.ContentScale
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*@Composable
fun ScreenSecond(m: Modifier,game: ) {
    val background = remember { Background(screenW) }
    var time by remember { mutableStateOf(0f) }
    var isPaused by remember { mutableStateOf(false) }
    var frog = remember { Frog(y = 0.dp, state = "frog1") }

    LaunchedEffect(isPaused) {
        if (!isPaused) {
            coroutineScope.launch {
                try {
                    while (time < 20f) {
                        time += 0.01f
                        background.roll()
                        delay(10)
                    }
                    onEnd()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        // Background scrolling logic
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "背景圖",
            contentScale = ContentScale.FillBounds, // 縮放符合螢幕寬度
            modifier = Modifier
                .offset { IntOffset(background.x1, 0) }
                .fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "背景圖2",
            contentScale = ContentScale.FillBounds, // 縮放符合螢幕寬度
            modifier = Modifier
                .offset { IntOffset(background.x2, 0) }
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text(text = "時間：%.2f".format(time))
        }

        Image(
            painter = painterResource(id = if (frog.state == "frog1") R.drawable.frog1 else R.drawable.frog2),
            contentDescription = "Frog",
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = frog.y)
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn1),
                contentDescription = "Button 1",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        jump(frog, 50.dp, coroutineScope, onBtn1Click)
                    }
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn2),
                contentDescription = "Button 2",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        jump(frog, 100.dp, coroutineScope, onBtn2Click)
                    }
            )
        }
    }
}*/