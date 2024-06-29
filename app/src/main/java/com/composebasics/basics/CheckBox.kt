package com.composebasics.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState

@Composable
fun CheckboxMinimalExample() {

    var checked by remember {
        mutableStateOf(true)
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Minimal Checkbox")
        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Magenta,
                checkmarkColor = Color.Cyan
            )
        )
    }
    Text(text = if (checked) "Checkbox is checked" else "Checkbox is unchecked")
}

@Composable
fun CheckboxParentExample() {

    var childCheckedStates = remember {
        mutableStateListOf(false, false, false)
    }
    val parentState: ToggleableState = when {
        childCheckedStates.all { it } -> ToggleableState.On
        childCheckedStates.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Select All")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState: Boolean = parentState != ToggleableState.On
                    childCheckedStates.forEachIndexed { index, isChecked ->
                        childCheckedStates[index] = newState
                    }
                })
        }

        childCheckedStates.forEachIndexed { index, isChecked ->
            Text(text = "option ${index + 1}")
            Checkbox(
                checked = isChecked,
                onCheckedChange = {
                    childCheckedStates[index] = it
                }
            )
        }

        if (childCheckedStates.all { it }){
            Text(text = "All option Selected")
        }
    }

}