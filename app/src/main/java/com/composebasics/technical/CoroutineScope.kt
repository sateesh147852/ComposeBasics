package com.composebasics.technical

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CoroutineScope() {

    val counter = remember {
        mutableStateOf(0)
    }
    val scope = rememberCoroutineScope()

    Column {
        Text(text = "Counter is running ${counter.value}")
        Button(onClick = {
            scope.launch {
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {

                }
            }
        }) {
            Text(text = "Start")
        }
    }

}