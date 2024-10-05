package com.composebasics.technical

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdateState() {
    val counter = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.value = 10
    }
    Counter(counter.value)
}

@Composable
fun Counter(value: Int) {
    val state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.i("Counter", "Counter: $state")
    }
    Text(text = "$value")
}