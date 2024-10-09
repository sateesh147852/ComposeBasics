package com.composebasics.bottomNavigation.part2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun BottomNav() {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        val navHostController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavigationItem(
                            "home_screen",
                            "Home",
                            Icons.Filled.Home
                        ),
                        BottomNavigationItem(
                            "chat_screen",
                            "Chat",
                            Icons.Filled.Notifications,
                            badgeCount = 15
                        ),
                        BottomNavigationItem(
                            "settings_screen",
                            "Settings",
                            Icons.Filled.Settings
                        )
                    ),
                    navController = navHostController,
                    onItemClick = {
                        navHostController.navigate(it.route)
                    }
                )
            }
        ) { paddingValues ->
            BottomNavigation2(navController = navHostController)
        }
    }
}

@Composable
fun BottomNavigation2(navController: NavHostController) {

    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") {
            HomeScreen()
        }
        composable("chat_screen") {
            ChatScreen()
        }
        composable("settings_screen") {
            SettingsScreen()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    onItemClick: (BottomNavigationItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        backgroundColor = Color.DarkGray,
        elevation = 5.dp,
    ) {
        items.forEach {
            val selected = it.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(it) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (it.badgeCount > 0) {
                            BadgedBox(badge = {
                                Text(text = it.badgeCount.toString())
                            }) {
                                Icon(imageVector = it.icon, contentDescription = it.name)
                            }
                        } else {
                            Icon(imageVector = it.icon, contentDescription = it.name)
                        }
                        if (selected) {
                            Text(
                                text = it.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp
                            )
                        }
                    }
                },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray
            )
        }
    }
}


@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Settings Screen")
    }
}