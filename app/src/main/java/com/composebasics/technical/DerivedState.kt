package com.composebasics.technical

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun DerivedStateExample() {

    val tableOf = remember {
        mutableIntStateOf(5)
    }

    val indexOf = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value += 1
        }
    }

    val message = remember {
        derivedStateOf {
            "${tableOf.intValue} * ${indexOf.value} = ${tableOf.intValue * indexOf.value}"
        }
    }

    Text(text = message.value, style = MaterialTheme.typography.displayLarge)
}