package com.example.frog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ScreenFirst(onStartClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.start_background),
            contentDescription = "Start Background",
            modifier = Modifier.fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.frog),
            contentDescription = "Frog",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(450.dp)
        )
        Column(
            modifier = Modifier
                //.align(Alignment.CenterStart)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.title),
                contentDescription = "Title",
                modifier = Modifier.size(500.dp)
            )
            //Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = R.drawable.start),
                contentDescription = "Start",
                modifier = Modifier
                    .size(10000.dp)
                    .clickable { onStartClick() }
            )
        }
    }
}