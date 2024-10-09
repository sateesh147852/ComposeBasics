package com.composebasics.bottomNavigation.part2

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val route: String,
    val name: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
)