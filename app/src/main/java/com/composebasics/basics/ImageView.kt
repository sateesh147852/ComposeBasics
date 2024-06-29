package com.composebasics.basics

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.composebasics.R

@Composable
fun ImageViewExample() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = ""
    )
}

@Composable
fun ImageVector() {
    Image(imageVector = Icons.Outlined.AccountCircle, contentDescription = "")
}

@Composable
fun AsyncImageExample() {
    AsyncImage(
        model = "https://sb.kaleidousercontent.com/67418/992x558/7632960ff9/people.png",
        contentDescription = ""
    )
}

@Composable
fun SVGImageExample() {
    Image(painter = painterResource(id = R.drawable.ic_cart), contentDescription = "")
}