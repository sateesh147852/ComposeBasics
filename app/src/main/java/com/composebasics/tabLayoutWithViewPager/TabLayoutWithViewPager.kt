package com.composebasics.tabLayoutWithViewPager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayoutWithViewPagerExample() {

    val tabItems = listOf(
        TabItem(
            "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),
        TabItem(
            "Email",
            Icons.Filled.Email,
            Icons.Outlined.Email
        ),
        TabItem(
            "Settings",
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        )
    )

    Column {

        val selectedTabIndex = remember {
            mutableIntStateOf(0)
        }
        val pagerState = rememberPagerState {
            tabItems.size
        }
        LaunchedEffect(selectedTabIndex.intValue) {
            pagerState.animateScrollToPage(selectedTabIndex.intValue)
        }
        LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
            if (!pagerState.isScrollInProgress)
                selectedTabIndex.intValue = pagerState.currentPage
        }

        TabRow(selectedTabIndex = selectedTabIndex.intValue) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(
                    selected = index == selectedTabIndex.intValue,
                    onClick = {
                        selectedTabIndex.intValue = index
                    },
                    icon = {
                        Icon(
                            imageVector = if (index == selectedTabIndex.intValue) tabItem.selectedIcon else tabItem.unSelectedIcon,
                            contentDescription = tabItem.title
                        )
                    },
                    text = {
                        Text(text = tabItem.title)
                    }
                )
            }
        }


        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { index ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = tabItems[index].title)
            }
        }
    }
}

data class TabItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)