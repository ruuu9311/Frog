package com.example.frog

import androidx.compose.ui.unit.Dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Frog(
    var y: Dp,val x: Dp,
    var state: String
) {

}

fun jump(frog: Frog, distance: Dp, coroutineScope: CoroutineScope, onJumpEnd: () -> Unit) {
    coroutineScope.launch {
        frog.y -= distance
        frog.state = "frog2"
        delay(180)
        frog.y += distance
        frog.state = "frog1"
        onJumpEnd()
    }
}