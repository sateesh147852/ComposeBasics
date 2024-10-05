package com.composebasics.technical

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun Recomposition() {
    Log.i("TextCompose", "Start: ")

    val value = remember {
        mutableDoubleStateOf(0.0)
    }

    Column {
        Button(onClick = {

        }) {
            Log.i("TextCompose", "Button 1: ")
            Text(text = "Text Button", fontSize = 30.sp)
        }
        Button(onClick = {
            value.doubleValue += 10f
        }) {
            Log.i("TextCompose", "Button 2: ")
            Text(text = "${value.doubleValue}", fontSize = 30.sp)
        }
    }
}