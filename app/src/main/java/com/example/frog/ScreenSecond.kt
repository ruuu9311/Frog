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
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

data class MovingImage(val resId: Int, var x: Float, var y: Float)

@Composable
fun ScreenSecond(
    onEnd: () -> Unit,
    onBtn1Click: () -> Unit,
    onBtn2Click: () -> Unit,
    onTouch: () -> Unit,
    coroutineScope: CoroutineScope,
    screenW: Int
) {
    val background = remember { Background(screenW) }
    var time by remember { mutableStateOf(0f) }
    var isPaused by remember { mutableStateOf(false) }
    var frog by remember { mutableStateOf(Frog(x = 380.dp, y = 400.dp, state = "frog1")) }
    var score by remember { mutableStateOf(0) }

    val imageList = remember { mutableStateListOf<MovingImage>() }

    LaunchedEffect(isPaused) {
        if (!isPaused) {
            coroutineScope.launch {
                try {
                    while (time < 20f) {
                        time += 0.01f
                        delay(10)
                    }
                    delay(1000)
                    onEnd()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    // Generate new images at random intervals
    LaunchedEffect(Unit) {
        while (true) {
            delay(Random.nextLong(1000, 2000))
            if (imageList.size < 5) {
                val images = listOf(R.drawable.shrimp, R.drawable.fish, R.drawable.fly)
                val randomImage = images[Random.nextInt(images.size)]
                val randomX = Random.nextFloat() * screenW
                imageList.add(MovingImage(randomImage, randomX, 400f))
            }
        }
    }

    // Update images positions based on background movement
    LaunchedEffect(background.x1) {
        imageList.forEach { image ->
            image.x -= (background.x1 / screenW.toFloat()) * screenW
        }
    }

    // Check for collisions and remove images if necessary
    LaunchedEffect(Unit) {
        while (true) {
            delay(50)
            imageList.removeAll { image ->
                val collided = checkCollision(frog, image)
                if (collided) {
                    score += 2
                }
                collided
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
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .offset { IntOffset(background.x1, 0) }
                .fillMaxSize()
        )
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "背景圖2",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .offset { IntOffset(background.x2, 0) }
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Text(
                text = "時間：%.2f".format(time),
                fontSize = 24.sp
            )
            Text(
                text = "分數：$score",
                fontSize = 24.sp
            )
        }

        Image(
            painter = painterResource(id = if (frog.state == "frog1") R.drawable.frog1 else R.drawable.frog2),
            contentDescription = "Frog",
            modifier = Modifier
                .offset(frog.x, frog.y)
                .size(if (frog.state == "frog1") 90.dp else 140.dp)
        )

        // Display and move random images
        imageList.forEach { image ->
            Image(
                painter = painterResource(id = image.resId),
                contentDescription = "Random Image",
                modifier = Modifier
                    .offset(image.x.dp, image.y.dp)
                    .size(50.dp) // Smaller size
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(1.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn1),
                contentDescription = "Button 1",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        coroutineScope.launch {
                            background.roll(215)
                            jump(frog, 90.dp, coroutineScope, onBtn1Click)
                        }
                    }
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(1.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn2),
                contentDescription = "Button 2",
                modifier = Modifier
                    .size(150.dp)
                    .clickable {
                        coroutineScope.launch {
                            background.roll(425)
                            jump(frog, 90.dp, coroutineScope, onBtn2Click)
                        }
                    }
            )
        }
    }
}

// Function to check collision between frog and image
fun checkCollision(frog: Frog, image: MovingImage): Boolean {
    val frogLeft = frog.x.value
    val frogRight = frog.x.value + (if (frog.state == "frog1") 90 else 140)
    val frogTop = frog.y.value
    val frogBottom = frog.y.value + (if (frog.state == "frog1") 90 else 140)

    val imageLeft = image.x
    val imageRight = image.x + 50
    val imageTop = image.y
    val imageBottom = image.y + 50

    return frogRight > imageLeft && frogLeft < imageRight &&
            frogBottom > imageTop && frogTop < imageBottom
}