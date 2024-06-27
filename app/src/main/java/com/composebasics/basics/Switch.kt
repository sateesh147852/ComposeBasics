package com.composebasics.basics

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

@Composable
fun SwitchMinimalExample() {
    var checked by remember {
        mutableStateOf(true)
    }
    Switch(
        checked = checked, onCheckedChange = {
            checked = it
        },
        enabled = true
    )
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember {
        mutableStateOf(false)
    }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(imageVector = Icons.Filled.Check, contentDescription = "")
            }
        } else {
            null
        }
    )
}

@Composable
fun SwitchWithCustomColors() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = Color.Magenta,
            uncheckedThumbColor = Color.Green,
            uncheckedTrackColor = Color.Red
        )
    )
}