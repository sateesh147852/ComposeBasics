package com.composebasics.datepicker

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerExample(onConfirm: (selectedMillis: Long?) -> Unit) {
    val isDialogOpen = remember {
        mutableStateOf(true)
    }
    val datePickerState = rememberDatePickerState()

    if (isDialogOpen.value){
        DatePickerDialog(
            onDismissRequest = {
                isDialogOpen.value = false
            },
            dismissButton = {
                TextButton(onClick = { isDialogOpen.value = false }) {
                    Text(text = "Cancel")
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    isDialogOpen.value = false
                    onConfirm(datePickerState.selectedDateMillis)
                }) {
                    Text(text = "ok")
                }
            }) {
            DatePicker(state = datePickerState)
        }
    }
}