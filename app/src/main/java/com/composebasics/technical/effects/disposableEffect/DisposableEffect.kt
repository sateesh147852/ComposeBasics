package com.composebasics.technical.effects.disposableEffect

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DisposableEffectExample() {
    val state = remember {
        mutableStateOf(false)
    }

    DisposableEffect(key1 = state.value) {
        Log.i("DisposableEffect", "DisposableEffect: ${state.value} started")
        onDispose {
            Log.i("DisposableEffect", "DisposableEffect: ${state.value} completed")
        }
    }

    Button(onClick = {
        state.value = !state.value
    }) {
        Text(text = "Update State")
    }
}