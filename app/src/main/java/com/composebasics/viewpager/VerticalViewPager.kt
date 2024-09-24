package com.composebasics.viewpager

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalViewPagerExample() {
    val pagerState = rememberPagerState {
        10
    }
    VerticalPager(
        state = pagerState,
        beyondBoundsPageCount = 5
    ) {
        Log.i("VerticalViewPagerExample", "VerticalViewPagerExample: $it")
        Text(
            text = "Page $it", modifier = Modifier
                .fillMaxSize()
                .background(Color.Magenta)
        )
    }
}