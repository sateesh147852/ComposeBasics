package com.composebasics.examples.quotes

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebasics.examples.quotes.model.Quotes


@Composable
fun QuoteListScreen() {

    val quote = remember {
        mutableStateOf<Quotes?>(null)
    }

    BackHandler {
        quote.value = null
    }

    val quoteArray = DataManager.getQuotes(LocalContext.current)

    quote.value?.let {
        QuoteDetailsScreen(quotes = it)
    } ?: run {

        QuoteList(quoteArray) {
            quote.value = it
        }

    }

}

@Composable
fun QuoteList(quoteArray: Array<Quotes>, onQuoteClick: (Quotes) -> Unit) {

    Column {
        Text(
            text = "Quotes List App",
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        LazyColumn {
            items(quoteArray) {
                QuoteListItem(it) {
                    onQuoteClick(it)
                }
            }
        }
    }
}

@Composable
fun QuoteListItem(quotes: Quotes, onQuoteClick: (Quotes) -> Unit) {
    Card(
        Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(10.dp)
    ) {
        Row(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .clickable {
                    onQuoteClick(quotes)
                }
        ) {
            Image(imageVector = Icons.Filled.Email, contentDescription = "")
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(text = quotes.quote, fontSize = 16.sp)
                Spacer(Modifier.size(4.dp))
                Divider(
                    Modifier
                        .fillMaxWidth(0.4f)
                        .height(1.dp)
                )
                Spacer(Modifier.size(4.dp))
                Text(text = quotes.author)
            }
        }
    }
}