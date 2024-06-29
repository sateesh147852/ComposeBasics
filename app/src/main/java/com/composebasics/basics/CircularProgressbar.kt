package com.composebasics.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun IndeterminateCircularIndicator() {

    var loading by remember {
        mutableStateOf(false)
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (loading) {
            CircularProgressIndicator()
        }

        Button(
            onClick = {
                loading = true
            }
        ) {
            Text(text = "Start Loading")
        }
    }
}

@Composable
fun IndeterminateCircularIndicator2() {
    var currentProgress by remember {
        mutableFloatStateOf(0f)
    }
    var isLoading by remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        if (isLoading) {
            CircularProgressIndicator(
                progress = currentProgress
            )
        }
        Button(
            onClick = {
                isLoading = true
                scope.launch {
                    loadProgress {
                        currentProgress = it
                    }
                    isLoading = false
                }
            }) {
            Text(text = "Start Loading")
        }
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        delay(100)
        updateProgress(i.toFloat() / 100)
    }
}