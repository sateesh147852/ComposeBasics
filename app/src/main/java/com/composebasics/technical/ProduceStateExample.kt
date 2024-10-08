package com.composebasics.technical

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ProduceStateExample() {

    val state = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(1000)
            value += 1
        }
    }

    Text(text = "${state.value}", style = MaterialTheme.typography.displayLarge)
}

@Composable
fun ProduceStateExample2() {

    val state = produceState(initialValue = 0) {
        while (true) {
            delay(25)
            value = (value + 10) % 360
        }
    }

    Box(
        contentAlignment = Alignment.Center, modifier =
        Modifier.fillMaxSize(1f)
    ) {
        Column {
            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(50.dp)
                    .rotate(state.value.toFloat())
            )
            Text(text = "Loading")
        }
    }
}
