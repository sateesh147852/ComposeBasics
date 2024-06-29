package com.composebasics.basics

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DividerExample() {
    Divider()
}

@Composable
fun DividerExample2() {
    Divider(modifier = Modifier.padding(10.dp), thickness = 4.dp, color = Color.Magenta)
}
