package com.composebasics.basics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import com.composebasics.R

@Composable
fun EditText(onClick: () -> Unit) {
    val text = remember {
        mutableStateOf("")
    }
    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier.fillMaxWidth(),
        enabled = true,
        readOnly = false,
        label = {
            Text(text = "username")
        },
        placeholder = {
            Text(text = "name")
        },
        prefix = {
            Text(text = "Mr.")
        },
        suffix = {
            Text(text = "C")
        },
        leadingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "")
        },
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.ic_settings), contentDescription = "")
        },
        singleLine = true,
        supportingText = {
            Text(text = "supporting")
        },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(onSearch = {
            onClick()
        }),
        isError = true,
        visualTransformation = VisualTransformation.None,



    )

}

@Composable
fun BasicEditText() {
    val text = remember {
        mutableStateOf("sateesh")
    }
    BasicTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
    )
}

@Composable
fun OutlinedTextField() {
    val text = remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = text.value, onValueChange = {
        text.value = it
    })
}

