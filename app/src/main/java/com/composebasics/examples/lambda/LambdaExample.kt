package com.composebasics.examples.lambda


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NotificationExample() {
    Column {
        val messageBarCount = remember {
            mutableIntStateOf(0)
        }
        NotificationScreen{
            messageBarCount.intValue = it
        }
        MessageBar(messageBarCount.intValue)
    }
}

@Composable
fun NotificationScreen(onIncrement: (Int) -> Unit) {
    val count = remember {
        mutableIntStateOf(0)
    }
    Text(text = "You have ${count.intValue} notifications")
    Spacer(modifier = Modifier.size(2.dp))
    Button(onClick = {
        onIncrement(++count.intValue)
    }) {
        Text(text = "Send Notifications")
    }
}

@Composable
fun MessageBar(messageBarCount: Int) {

    Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(4.dp)) {
        Row(Modifier.padding(8.dp)) {
            Image(imageVector = Icons.Filled.Favorite, contentDescription = "")
            Text(text = "Message Sent so far - $messageBarCount")

        }
    }
}