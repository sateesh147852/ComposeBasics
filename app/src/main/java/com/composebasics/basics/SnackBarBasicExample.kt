package com.composebasics.basics

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


@Composable
fun SnackBarBasicExample() {
    var scope = rememberCoroutineScope()
    val snackbarHostState = SnackbarHostState()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Internal server error")
                    }
                }
            ) {
                Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
                Text(text = "show")
            }
        }

    ) { paddingValues ->

    }
}

@Composable
fun SnackBarWithActionExample(onAction: (String) -> Unit) {
    val scope = rememberCoroutineScope()
    val snackbarHostState = SnackbarHostState()

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = {
                    Text(text = "Show")
                },
                icon = {
                    Icon(imageVector = Icons.Outlined.Add, contentDescription = "")
                },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState.showSnackbar(
                            message = "Message has been deleted",
                            actionLabel = "undo",
                            withDismissAction = true,
                            duration = SnackbarDuration.Short
                        )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                onAction("Action Performed")
                            }

                            SnackbarResult.Dismissed -> {
                                onAction("Action Dismissed")
                            }
                        }
                    }
                })
        }
    ) { paddingValues ->

    }
}