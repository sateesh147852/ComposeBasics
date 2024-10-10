package com.composebasics.navigationDrawer.part2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composebasics.R
import kotlinx.coroutines.launch

@Composable
fun NavigationScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = listOf(
                    MenuItem(
                        title = "Home",
                        id = "home",
                        Icons.Filled.Home
                    ),
                    MenuItem(
                        title = "Chat",
                        id = "chat",
                        Icons.Filled.Notifications
                    ),
                    MenuItem(
                        title = "Settings",
                        id = "settings",
                        Icons.Filled.Settings
                    ),
                    MenuItem(
                        title = "Email",
                        id = "email",
                        Icons.Filled.Email
                    )
                )
            ) {
                println("${it.title} is clicked")
            }
        }
    ) { paddingValues ->

    }
}

@Composable
fun AppBar(onNavigationIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
            )
        },
        backgroundColor = MaterialTheme.colors.primary,
        navigationIcon = {
            IconButton(onClick = {
                onNavigationIconClick()
            }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "")
            }
        }
    )
}

@Composable
fun DrawerHeader() {

    Box(
        modifier = Modifier
            .background(Color.Green)
            .padding(64.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    onClickMenuItem: (MenuItem) -> Unit
) {
    LazyColumn {
        items(items) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClickMenuItem(it)
                }
                .padding(16.dp)
            ) {
                Icon(imageVector = it.imageVector, contentDescription = it.title)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = it.title, modifier = Modifier.weight(1f))
            }
        }
    }
}