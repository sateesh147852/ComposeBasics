package com.composebasics.list.horizontal

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalStaggeredGrid() {
    LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Fixed(6)) {
        items(100){
            if (it % 2 == 0){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(50.dp))
            }else{
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(80.dp))
            }
        }
    }
}

@Composable
fun HorizontalStaggeredGrid2() {
    LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.Adaptive(100.dp)) {
        items(100){
            if (it % 2 == 0){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(50.dp))
            }else{
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(80.dp))
            }
        }
    }
}

@Composable
fun HorizontalStaggeredGrid3() {
    LazyHorizontalStaggeredGrid(rows = StaggeredGridCells.FixedSize(100.dp)){
        items(100){
            if (it % 2 == 0){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(50.dp))
            }else{
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(80.dp))
            }
        }
    }
}