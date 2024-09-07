package com.composebasics.list.vertical

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(5)) {
        items(100) {
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "",modifier = Modifier.width(300.dp).height(200.dp)
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
                contentDescription = "",modifier = Modifier.size(20.dp)
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
                    contentDescription = "",modifier = Modifier.size(20.dp)
                )
        }

    }
}