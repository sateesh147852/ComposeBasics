package com.composebasics.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LinearDeterminateIndicator() {

    val currentProgress = remember {
        mutableFloatStateOf(0f)
    }
    val isLoading = remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {

        Button(
            onClick = {
                isLoading.value = true
                scope.launch {
                    getProgress {
                        currentProgress.floatValue = it
                    }
                    isLoading.value = false
                }
            },
        ) {
            Text(text = "Start", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        }

        Spacer(modifier = Modifier.height(20.dp))

        //if (isLoading.value) {
            LinearProgressIndicator(
                progress = currentProgress.floatValue,
                modifier = Modifier.fillMaxWidth(),
                trackColor = Color.Magenta,
                strokeCap = StrokeCap.Round,
                color = Color.Green
            )
        //}
    }

}

suspend fun getProgress(updateProgress: (Float) -> Unit) {
    for (index in 1..100) {
        delay(100)
        updateProgress(index.toFloat() / 100)
    }
}