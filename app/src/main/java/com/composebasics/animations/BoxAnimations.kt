package com.composebasics.animations

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BoxAnimations() {

    val size = remember {
        mutableStateOf(200.dp)
    }

    val animateState = animateDpAsState(
        targetValue = size.value,
        tween(
            durationMillis = 3000,
            delayMillis = 300,
            easing = LinearOutSlowInEasing
        )

    )
    Box(
        modifier = Modifier
            .size(animateState.value)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            size.value += 50.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}

@Composable
fun BoxAnimations2() {

    val size = remember {
        mutableStateOf(200.dp)
    }

    val animateState = animateDpAsState(
        targetValue = size.value,
        spring(Spring.DampingRatioHighBouncy)

    )
    Box(
        modifier = Modifier
            .size(animateState.value)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            size.value += 50.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}

@Composable
fun BoxAnimations3() {

    val size = remember {
        mutableStateOf(200.dp)
    }

    val animateState = animateDpAsState(
        targetValue = size.value,
        keyframes {
            durationMillis = 5000
            size.value at 0 with LinearEasing
            size.value * 1.5f at 1000 with FastOutLinearInEasing
            size.value * 2f at 5000
        }

    )
    Box(
        modifier = Modifier
            .size(animateState.value)
            .background(Color.Magenta),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            size.value += 50.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}

@Composable
fun BoxAnimations4() {

    val size = remember {
        mutableStateOf(200.dp)
    }
    val sizeState = animateDpAsState(
        targetValue = size.value,
        keyframes {
            durationMillis = 5000
            size.value at 0 with LinearEasing
            size.value * 1.5f at 1000 with FastOutLinearInEasing
            size.value * 2f at 5000
        }
    )

    val infiniteTransition = rememberInfiniteTransition(label = "")
    val color = infiniteTransition.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(color.value)
            .size(sizeState.value)
    ) {
        Button(onClick = {
            size.value += 50.dp
        }) {
            Text(text = "Increase Size")
        }
    }
}

@Composable
fun BoxAnimations5() {


    val infiniteTransition = rememberInfiniteTransition(label = "")
    val size = infiniteTransition.animateFloat(
        initialValue = 50f, targetValue = 300f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val infiniteTransition2 = rememberInfiniteTransition(label = "")
    val color = infiniteTransition2.animateColor(
        initialValue = Color.Red,
        targetValue = Color.Green,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 3000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(size.value.dp)
            .background(color.value)
    ) {
        Text(text = "Increase Button")
    }

}

