package com.composebasics.dropDown

import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun DropDownMenuExample() {
    val isExpanded = remember {
        mutableStateOf(true)
    }
    DropdownMenu(
        expanded = isExpanded.value,
        onDismissRequest = {
            isExpanded.value = false
        }) {
        DropdownMenuItem(
            text = {
                Text(text = "Name")
            }, onClick = {

            })
        Divider()
        DropdownMenuItem(
            text = {
                Text(text = "Password")
            }, onClick = {

            })
        Divider()
        DropdownMenuItem(
            text = {
                Text(text = "Email")
            }, onClick = {

            })
        Divider()
        DropdownMenuItem(
            text = {
                Text(text = "Mobile")
            }, onClick = {

            })
    }
}