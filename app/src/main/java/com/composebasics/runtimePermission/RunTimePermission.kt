package com.composebasics.runtimePermission

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberMultiplePermissionsState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestPermission() {

    val permissionsState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA
        )
    )

    val showPermissionStatus = remember {
        mutableStateOf(false)
    }

    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (showPermissionStatus.value) {
            permissionsState.permissions.forEach { perm ->
                when {
                    perm.status.isGranted -> {
                        Text(text = "${perm.permission} permission is accepted")
                    }

                    !perm.status.isGranted -> {
                        Text(text = "${perm.permission} Permission is denied")
                    }
                }
            }
        }

        Button(onClick = {
            permissionsState.launchMultiplePermissionRequest()
            permissionsState.permissions.forEach {

            }
            showPermissionStatus.value = true
        }) {
            Text(text = "Request Permission")
        }
    }
}