package com.composebasics.list.vertical

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VerticalStaggeredGrid() {

    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Fixed(2)) {
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
fun VerticalStaggeredGrid2() {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.Adaptive(70.dp)) {
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
fun VerticalStaggeredGrid3() {
    LazyVerticalStaggeredGrid(columns = StaggeredGridCells.FixedSize(70.dp)) {
        items(100){
            if (it % 2 == 0){
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(50.dp))
            }else{
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "", modifier = Modifier.size(80.dp))
            }
        }
    }
}