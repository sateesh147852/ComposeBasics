package com.composebasics.list.horizontal

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalView() {
    LazyRow {
        items(100) {
            Text(text = "item $it", modifier = Modifier.padding(10.dp))
        }

    }
}

@Composable
fun HorizontalScrollView2() {
    LazyRow {
        items(
            listOf(
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3"
            )
        ) {
            Text(text = it, modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun HorizontalScrollView3() {
    LazyRow {
        itemsIndexed(
            listOf(
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3",
                "items1",
                "items2",
                "item3"
            )
        ) { index, item ->
            Text(text = "$index $item", Modifier.padding(10.dp))
        }
    }
}

@Composable
fun HorizontalScrollView4() {
    Row(
        modifier = Modifier.horizontalScroll(rememberScrollState(), enabled = true)
    ) {
        repeat(50) {
            Text(text = "item $it", modifier = Modifier.padding(20.dp))
        }
    }
}