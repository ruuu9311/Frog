package com.example.frog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ScoreScreen(
    score: Int,
    btn1Count: Int,
    btn2Count: Int,
    touchedObjectsCount: Int,
    onRestartClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.start_background),
            contentDescription = "Start Background",
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.memo),
                contentDescription = "Title",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "距離：${(btn1Count + btn2Count) * 10}")
            Text(text = "食物：${touchedObjectsCount}")
            Text(text = "分數：${(btn1Count + btn2Count) * 10 + touchedObjectsCount}")
        }
        Image(
            painter = painterResource(id = R.drawable.frog),
            contentDescription = "Frog",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(500.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.frog4),
            contentDescription = "Restart",
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .size(100.dp)
                .clickable { onRestartClick() }
        )
    }
}