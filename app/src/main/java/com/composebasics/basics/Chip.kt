package com.composebasics.basics

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AssistChipExample(onClick: () -> Unit) {

    AssistChip(
        onClick = {
            onClick()
        },
        label = {
            Text(text = "Assist Chip")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Settings, contentDescription = "")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
        },
    )
}

@Composable
fun ElevatedAssistChipExample(onClick: () -> Unit) {

    ElevatedAssistChip(
        onClick = {
            onClick()
        },
        label = {
            Text(text = "Assist Chip")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Outlined.Settings, contentDescription = "")
        },
        trailingIcon = {
            Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
        },
    )
}

@Composable
fun SuggestionChipExample(onClick: () -> Unit) {
    SuggestionChip(
        onClick = {
                  onClick()
        },
        label = {
            Text(text = "Suggestion Chip")
        }
    )
}

@Composable
fun ElevatedSuggestionChipExample(onClick: () -> Unit) {
    ElevatedSuggestionChip(
        onClick = {
            onClick()
        },
        label = {
            Text(text = "Suggestion Chip")
        }
    )
}