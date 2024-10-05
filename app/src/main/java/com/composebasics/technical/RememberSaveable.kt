package com.composebasics.technical

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RememberSaveable() {
    val count = rememberSaveable {
        mutableIntStateOf(0)
    }

    Column {
        Text(text = "You have ${count.intValue} notifications")
        Spacer(modifier = Modifier.padding(4.dp))
        Button(onClick = {
            count.intValue++
        }) {
            Text(text = "Send Notification")
        }
    }
}