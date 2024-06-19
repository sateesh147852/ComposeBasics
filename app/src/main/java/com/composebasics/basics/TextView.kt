package com.composebasics.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ComposeTextView() {
    Text(
        text = "Text is a central piece of any UI, and Jetpack Compose makes it easier to display or write text.",
        modifier = Modifier
            .padding(5.dp)
            .background(Color.Cyan),
        color = Color.Magenta,
        fontSize = 25.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Light,
        fontFamily = FontFamily.Monospace,
        textDecoration = TextDecoration.Underline,
        letterSpacing = 2.sp,
        textAlign = TextAlign.Start,
        lineHeight = 10.sp,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
        softWrap = true
    )
}

@Composable
fun AnnotatedTextView(onClick : () -> Unit) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = Color.Magenta, fontSize = 22.sp)) {
                append("S")
            }
            append("ateesh")
            append(" ")
            withStyle(style = SpanStyle(color = Color.Magenta, fontSize = 22.sp)) {
                append("C")
            }
            append("hikkalagi")
        },
        color = Color.Green,
        fontSize = 18.sp,
        modifier = Modifier.clickable {
            onClick()
        }
    )
}