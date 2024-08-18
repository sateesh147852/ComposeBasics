package com.composebasics.verticalScroll

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VerticalScrollExample() {

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .size(300.dp)
            .verticalScroll(
                rememberScrollState(),
                enabled = true,
                reverseScrolling = true
            )
    ) {
        repeat(30) {
            Text(text = "item $it", modifier = Modifier.padding(10.dp))
        }
    }
}