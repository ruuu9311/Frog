package com.example.frog

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

data class Food(
    var x: Dp,
    var y: Dp,
    var type: String
)

fun moveFood(food: Food, screenW: Int, coroutineScope: CoroutineScope) {
    coroutineScope.launch {
        while (true) {
            delay(10)
            food.x -= 1.dp
            if (food.x < (-50).dp) {
                food.x = screenW.dp
                food.y = Random.nextInt(0, 800).dp  // 假設螢幕高度為800dp
            }
        }
    }
}