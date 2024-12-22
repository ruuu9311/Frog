package com.example.frog

class Background(val screenW: Int) {
    var x1 = 0 // 第一張背景圖的 x 軸位置
    var x2 = screenW // 第二張背景圖的 x 軸位置

    fun roll(distance: Int) {
        x1 -= distance
        x2 -= distance
        if (x1 <= -screenW) { // 當第一張背景圖完全移出螢幕時，重置位置
            x1 = x2 + screenW
        }
        if (x2 <= -screenW) { // 當第二張背景圖完全移出螢幕時，重置位置
            x2 = x1 + screenW
        }
    }
}