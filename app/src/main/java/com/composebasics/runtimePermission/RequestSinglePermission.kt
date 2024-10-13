package com.composebasics.runtimePermission

import android.Manifest
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.shouldShowRationale

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun RequestSinglePermission() {

    val permissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
    val showPermission = remember {
        mutableStateOf(false)
    }

    Column {
        if (showPermission.value) {
            when {
                permissionState.status.isGranted -> {
                    Text(text = "${permissionState.permission} permission is accepted")
                }

                !permissionState.status.isGranted && !permissionState.status.shouldShowRationale -> {
                    Text(text = "${permissionState.permission} permission is denied")
                }
            }
        } else {
            when {
                permissionState.status.isGranted -> {
                    Text(text = "${permissionState.permission} permission is accepted")
                }

                permissionState.status.shouldShowRationale -> {
                    Text(text = "${permissionState.permission} permission is required to access Camera")
                }

                !permissionState.status.isGranted && !permissionState.status.shouldShowRationale -> {
                    Text(text = "${permissionState.permission} permission is denied")
                }
            }
        }
        Button(onClick = {
            showPermission.value = true
            permissionState.launchPermissionRequest()
        }) {
            Text(text = "Request Permission")
        }
    }
}