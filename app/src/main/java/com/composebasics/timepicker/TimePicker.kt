package com.composebasics.timepicker

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerExample(onConfirmButton: (TimePickerState) -> Unit) {

    val currentTime = Calendar.getInstance()
    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = false,
    )
    TimePickerDialog(
        onConfirmButton = { onConfirmButton(timePickerState) },
        onDismissButton = { }) {
        TimePicker(state = timePickerState)
    }
}

@Composable
fun TimePickerDialog(
    onConfirmButton: () -> Unit,
    onDismissButton: () -> Unit,
    content: @Composable () -> Unit
) {

    val isAlertDialogOpen = remember {
        mutableStateOf(true)
    }
    if (isAlertDialogOpen.value){
        AlertDialog(
            onDismissRequest = { },
            confirmButton = {
                TextButton(onClick = {
                    onConfirmButton()
                    isAlertDialogOpen.value = false
                }) {
                    Text(text = "ok")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    onDismissButton()
                    isAlertDialogOpen.value = false
                }) {
                    Text(text = "Cancel")
                }
            },
            text = { content() }
        )
    }
}


