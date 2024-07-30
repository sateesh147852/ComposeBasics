package com.composebasics.dialog

import androidx.compose.foundation.Image
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.composebasics.R

@Composable
fun AlertDialogSample() {

    var isDialogOpen by remember {
        mutableStateOf(false)
    }

    Button(onClick = {
        isDialogOpen = true
    }) {
        Text(text = "Show Dialog")
    }

    if (isDialogOpen) {
        AlertDialog(
            onDismissRequest = {
                isDialogOpen = false
            },
            confirmButton = {
                Button(
                    onClick = {
                        isDialogOpen = false
                    }
                ) {
                    Text(text = "Submit")
                }
            },
            title = {
                Text(text = "This is the title")
            },
            text = {
                Text(text = "This is the subtitle This is the subtitle This is the subtitle This is the subtitle This is the subtitle This is the subtitle")
            },
            dismissButton = {
                Button(
                    onClick = {
                        isDialogOpen = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            },
            icon = {
                Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "")
            },
            titleContentColor = Color.Green,
            iconContentColor = Color.Red
        )
    }
}