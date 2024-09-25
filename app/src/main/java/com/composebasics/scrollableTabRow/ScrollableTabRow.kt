package com.composebasics.scrollableTabRow

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ScrollableTabRowExample() {

    val tabItem = listOf(
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
        ),
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
        ),
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

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    ScrollableTabRow(selectedTabIndex = selectedIndex.intValue) {
        tabItem.forEachIndexed { index, tabItem ->
            Tab(
                selected = index == selectedIndex.intValue,
                icon = {
                    Icon(
                        imageVector = if (index == selectedIndex.intValue) tabItem.selectedIcon else tabItem.unSelectedIcon,
                        contentDescription = tabItem.title
                    )
                },
                onClick = {
                    selectedIndex.intValue = index
                },
                text = {
                    Text(text = tabItem.title)
                }
            )
        }
    }
}

data class TabItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
)