package com.example.frog.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun GameTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        content = content
    )
}