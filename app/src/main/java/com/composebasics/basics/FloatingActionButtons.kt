package com.composebasics.basics

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun FloatingActionButtonExample(onClick: () -> Unit) {

    FloatingActionButton(
        onClick = {
            onClick()
        },
    ) {
        Row {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        }
    }
}

@Composable
fun SmallFloatingActionButtonExample(onClick: () -> Unit) {
    SmallFloatingActionButton(
        onClick = {
            onClick()
        },
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "")

    }
}

@Composable
fun LargeFloatingActionButtonExample(onClick: () -> Unit) {
    LargeFloatingActionButton(
        onClick = {
            onClick()
        },
        shape = CircleShape
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
    }
}

@Composable
fun ExtendedFloatingActionButtonExample(onClick: () -> Unit) {
    ExtendedFloatingActionButton(onClick = {
        onClick()
    }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "")
        Text(text = "Compose")
    }
}

