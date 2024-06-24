package com.composebasics.basics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilledButtonExample(onClick: () -> Unit) {
    Button(
        onClick = {
            onClick()
        },
        modifier = Modifier,
        enabled = true,
        shape = RoundedCornerShape(5.dp),
        /*colors = ButtonDefaults.buttonColors(
            containerColor = Color.Magenta,
            contentColor = Color.Cyan
        ),*/
        elevation = ButtonDefaults.buttonElevation(10.dp),
        //border = BorderStroke(2.dp, color = Color.Green),
        contentPadding = PaddingValues(30.dp)
    )
    {
        Column {
            Text(text = "Filled")
            Text(text = "Filled Two")
        }
    }
}

@Composable
fun FilledTonalButtonExample(onClick: () -> Unit) {
    FilledTonalButton(
        onClick = {
            onClick()
        },
        enabled = true,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, color = Color.Yellow),

        ) {
        Text(text = "FilledTonalButton")
    }
}

@Composable
fun OutlinedButtonExample(onClick: () -> Unit) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = Modifier,
        enabled = true,
        /*shape = RoundedCornerShape(1.dp),
        elevation = ButtonDefaults.buttonElevation(5.dp)*/


    ) {
        Text(text = "OutlinedButton")
    }
}

@Composable
fun ElevatedButtonExample(onClick: () -> Unit) {
    ElevatedButton(
        onClick = {
            onClick()
        },
        enabled = true,
        modifier = Modifier,
        shape = RoundedCornerShape(2.dp),
    ) {
        Text(text = "ElevatedButton")
    }
}

@Composable
fun TextButtonExample(onClick: () -> Unit) {
    TextButton(
        onClick = {
            onClick()
        }
    ) {
        Text(text = "Text Button")
    }
}