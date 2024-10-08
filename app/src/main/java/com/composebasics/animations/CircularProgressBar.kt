package com.composebasics.animations

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CircularProgressBarExample(
    percentage: Float,
    number: Int,
    radius: Dp = 50.dp,
    fontSize: TextUnit = 28.sp,
    animationDuration: Int = 3000,
    animDelay: Int = 300,
    strokeWidth: Dp = 8.dp,
    color: Color = Color.Green

) {

    val isAnimationPlayed = remember {
        mutableStateOf(false)
    }

    val currentPercentage =
        animateFloatAsState(
            targetValue = if (isAnimationPlayed.value) percentage else 0f,
            label = "",
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animDelay
            )
        )

    LaunchedEffect(key1 = true) {
        isAnimationPlayed.value = true
    }

    Box(contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)) {
        Canvas(modifier = Modifier.size(radius * 2f)) {

            drawArc(
                color = color,
                -90f,
                360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Text(
            text = (currentPercentage.value * number).toInt().toString(),
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}