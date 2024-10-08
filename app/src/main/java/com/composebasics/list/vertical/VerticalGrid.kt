package com.composebasics.list.vertical

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VerticalGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(5)) {
        items(100) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "", modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
            )
        }
    }
}

@Composable
fun VerticalGrid2() {
    LazyVerticalGrid(columns = GridCells.FixedSize(100.dp)) {
        items(100) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "", modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun VerticalGrid3() {
    LazyVerticalGrid(columns = GridCells.Adaptive(90.dp)) {
        items(100) {
            if (it % 2 == 0)
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "", modifier = Modifier.size(100.dp)
                )
            else
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "", modifier = Modifier.size(20.dp)
                )
        }

    }
}

@Composable
fun VerticalGrid4() {

    val state = rememberLazyGridState(
        initialFirstVisibleItemIndex = 99
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(5),
        state = state
    ) {
        items(100) {
            Box(
                Modifier
                    .padding(8.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(5.dp))
                    .size(30.dp)
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Item $it")
            }
        }
    }
}