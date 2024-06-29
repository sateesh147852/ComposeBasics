package com.composebasics.basics

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

@Composable
fun RadioButtonExample() {

    var selected by remember {
        mutableStateOf(false)
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Male")
        RadioButton(
            selected = selected,
            onClick = {
                selected = !selected
            })
    }
}

@Composable
fun MultipleRadioButtonsExample() {

    val genderList = listOf("Male", "Female", "Others")
    val (selectedOption, selectedTest) = remember { mutableStateOf(genderList[0]) }

    Column {
            genderList.forEach {
                Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (it == selectedOption),
                    onClick = {
                        selectedTest(it)
                    }
                )
                Text(text = it)
            }
        }
    }
}