package com.example.teamproject_sns

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webContentsView)
        webView.webViewClient = WebViewClient()
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.loadUrl(intent.getStringExtra("url").toString())
    }
}