package com.composebasics.list.vertical

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalScrollView() {
    LazyColumn {
        items(100) {
            Text(text = "item $it", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun VerticalScrollView2() {
    LazyColumn(reverseLayout = false) {
        items(listOf("sateesh", "ramesh", "kiran")) {
            Text(text = it, modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
fun VerticalScrollView3() {
    LazyColumn {
        itemsIndexed(
            listOf(
                "sateesh",
                "ramesh",
                "kiran",
                "sateesh",
                "ramesh",
                "kiran",
                "sateesh",
                "ramesh",
                "kiran",
                "sateesh",
                "ramesh",
                "kiran",
                "sateesh",
                "ramesh",
                "kiran",
                "sateesh",
                "ramesh",
                "kiran"
            )
        ) { index, data ->
            Text(text = "$index $data", modifier = Modifier.padding(20.dp))
        }
    }
}

@Composable
fun VerticalScrollView4() {
    Column(
        modifier = Modifier.verticalScroll(
            rememberScrollState(),
            enabled = true
        )
    ) {
        repeat(50) {
            Text(text = "item $it", modifier = Modifier.padding(20.dp))
        }
    }
}

