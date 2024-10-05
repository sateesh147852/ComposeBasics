package com.composebasics.technical.effects.launchedEffect

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun LaunchedEffectExample() {
    val count = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(count.value % 3 == 0) {
        Log.i("LaunchedEffectExample", "LaunchedEffectExample: ${count.value}")
    }

    Button(onClick = {
        ++count.value
    }) {
        Text(text = "Increment Counter")
    }
}