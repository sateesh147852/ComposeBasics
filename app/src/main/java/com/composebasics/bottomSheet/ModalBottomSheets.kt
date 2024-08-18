package com.composebasics.bottomSheet

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalBottomSheetExample() {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    val scope = rememberCoroutineScope()
    val showBottomSheet = remember {
        mutableStateOf(false)
    }
    val text = remember {
        mutableStateOf("")
    }

    if (showBottomSheet.value) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet.value = false
            },
            sheetState = sheetState,
            shape = BottomSheetDefaults.ExpandedShape,
            containerColor = Color.Magenta,
            tonalElevation = 20.dp,
            modifier = Modifier.fillMaxHeight()
        ) {
            IconButton(
                onClick = {
                    scope.launch {
                        showBottomSheet.value = false
                        sheetState.hide()
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "")
            }
            Spacer(modifier = Modifier.height(100.dp))
            OutlinedTextField(
                value = text.value, onValueChange = {
                    text.value = it
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

    Button(onClick = {
        scope.launch {
            showBottomSheet.value = true
            sheetState.show()
        }
    }) {
        Text(text = "Show Bottom Sheet")
    }

}