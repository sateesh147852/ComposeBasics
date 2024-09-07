package com.composebasics.list.horizontal

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalGrid() {
    
    LazyHorizontalGrid(rows = GridCells.Fixed(5)) {
        items(100){
            //Text(text = "item $it", modifier = Modifier.width(50.dp))
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "",modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun HorizontalGrid2() {
    LazyHorizontalGrid(rows = GridCells.FixedSize(50.dp)) {
        items(100){
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "",modifier = Modifier.size(100.dp)
            )
        }
    }
}

@Composable
fun HorizontalGrid3() {
    LazyHorizontalGrid(rows = GridCells.Adaptive(100.dp)) {
        items(100){
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "",modifier = Modifier.size(100.dp)
            )
        }
    }
}