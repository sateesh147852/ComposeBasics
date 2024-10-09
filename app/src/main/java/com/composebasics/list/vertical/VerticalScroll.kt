package com.composebasics.list.vertical

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun VerticalScrollView5() {

    val items = remember {
        mutableStateOf(
            (1..100).map {
                ListItem("item $it", false)
            }
        )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(items.value.size) { index ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    items.value = items.value.mapIndexed { j, item ->
                        if (index == j) {
                            item.copy(isSelected = !item.isSelected)
                        } else {
                            item
                        }
                    }
                }
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = items.value[index].title)
                if (items.value[index].isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

