package com.composebasics.basics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun SliderMinimalExample() {

    var sliderPosition by remember {
        mutableFloatStateOf(0f)
    }

    Slider(
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
        },
        valueRange = 1f..20f,
        steps = 10
    )
    Text(
        text = String.format("%d", sliderPosition.toInt()),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember {
        mutableStateOf(0f..20f)
    }
    RangeSlider(
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
        },
        valueRange = 0f..20f,
        steps = 10,
    )
    Text(
        text = sliderPosition.toString(),
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}