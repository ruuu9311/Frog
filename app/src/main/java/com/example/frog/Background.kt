package com.example.frog

class Background(val screenW: Int) {
    var x1 = 0 // 背景圖1的x軸
    var x2 = screenW // 背景圖2的x軸

    fun roll() {
        x1--
        x2--
        if (x1 <= -screenW) { // 當背景圖1完全移出螢幕時，重置位置
            x1 = screenW
        }
        if (x2 <= -screenW) { // 當背景圖2完全移出螢幕時，重置位置
            x2 = screenW
        }
    }
}