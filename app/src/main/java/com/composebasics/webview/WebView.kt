package com.composebasics.webview

import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewExample() {

    val url = "https://medium.com/@kevinnzou/using-webview-in-jetpack-compose-bbf5991cfd14"

    AndroidView(factory = {
        WebView(it).apply {
            loadUrl(url)
        }
    })
}