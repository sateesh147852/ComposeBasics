package com.composebasics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SwipeToRefreshExample() {

    val refreshing = remember {
        mutableStateOf(false)
    }
    val scope = rememberCoroutineScope()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = refreshing.value),
        onRefresh = {
            scope.launch {
                refreshing.value = true
                delay(3000)
                refreshing.value = false
            }
        },
        modifier = Modifier.fillMaxWidth()
    ) {

        LazyColumn {
            items(100){
                Text(text = "Item $it", modifier = Modifier.padding(10.dp))
            }
        }
    }
}