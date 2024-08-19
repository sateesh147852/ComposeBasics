package com.composebasics

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalScrollExample() {

    Row(
        modifier = Modifier
            .padding(10.dp)
            .size(400.dp)
            .background(Color.LightGray)
            .horizontalScroll(
                rememberScrollState(),
                enabled = true,
                reverseScrolling = true
            )
    ) {
        repeat(30) {
            Text(
                text = "item $it", modifier = Modifier
                    .padding(10.dp)
            )
        }
    }
}