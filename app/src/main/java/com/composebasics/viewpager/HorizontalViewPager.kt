package com.composebasics.viewpager

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalViewPagerExample() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })

    HorizontalPager(state = pagerState) {
        Text(
            text = "Page $it", modifier = Modifier
                .fillMaxSize()
                .background(Color.Cyan)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollToPosition() {
    val pagerState = rememberPagerState {
        10
    }

    HorizontalPager(state = pagerState) {
        Text(
            text = "Page: $it",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
                .height(500.dp)
        )
    }

    val coroutineScope = rememberCoroutineScope()
    Button(onClick = {
        coroutineScope.launch {
            //pagerState.scrollToPage(5)
            pagerState.animateScrollToPage(5)
        }
    }) {
        Text(text = "Jump to page 5")
    }

    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect {
            Log.i("ScrollToPosition", "ScrollToPosition: $it")
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PageIndicatorExample() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) { page ->
        Text(text = "Page: $page")
    }
    Row(
        Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount){
            val color = if (pagerState.currentPage == it) Color.DarkGray else Color.LightGray
            Box(
                Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}
