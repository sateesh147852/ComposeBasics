package com.composebasics.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CardMinimalExample() {
    Card(modifier = Modifier.size(240.dp, 100.dp)) {
        Text(text = "Hello World", modifier = Modifier.padding(12.dp))
    }
}

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.size(width = 240.dp, height = 100.dp),
        border = BorderStroke(2.dp, color = Color.Magenta),
    ) {
        Text(
            text = "Filled",
            modifier = Modifier.padding(12.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ElevatedCardExample(onclick: (String) -> Unit) {

    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .size(240.dp, 100.dp)
            .clickable {
                onclick("ElevatedCard card is clicked")
            },
    ) {
        Text(
            text = "ElevatedCard",
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun OutlinedCardExample() {

    OutlinedCard(
        modifier = Modifier.size(240.dp, 100.dp)
    ) {
        Text(text = "OutlinedCard", modifier = Modifier.padding(12.dp))
    }
}