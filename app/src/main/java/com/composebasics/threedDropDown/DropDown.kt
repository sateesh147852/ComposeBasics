package com.composebasics.threedDropDown

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ThreeDDropDown() {
    DropDown(
        text = "Hello World",
        isInitiallyOpened = false
    ) {
       Text(
            text = "The 3D Image", modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.Green)
        )
    }
}

@Composable
fun DropDown(
    text: String,
    isInitiallyOpened: Boolean,
    content: @Composable () -> Unit
) {

    val isOpen = remember {
        mutableStateOf(isInitiallyOpened)
    }

    val alpha = animateFloatAsState(
        targetValue = if (isOpen.value) 1f else 0f,
        tween(
            durationMillis = 300
        ), label = ""
    )

    val rotateX = animateFloatAsState(
        targetValue = if (isOpen.value) 0f else -90f,
        tween(
            durationMillis = 300
        ), label = ""
    )

    Column(Modifier.fillMaxWidth()) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = text, fontSize = 16.sp)

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "",
                Modifier
                    .clickable {
                        isOpen.value = !isOpen.value
                    }
                    .scale(1f, if (isOpen.value) -1f else 1f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer {
                    transformOrigin = TransformOrigin(0.5f, 0f)
                    rotationX = rotateX.value
                }
        ) {
            content()
        }


    }


}