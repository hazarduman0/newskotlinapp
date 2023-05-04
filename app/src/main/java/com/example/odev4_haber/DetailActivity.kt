package com.example.odev4_haber

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        webView = findViewById(R.id.webView)

        webView.settings.javaScriptEnabled = true

        val url = intent.getStringExtra("url")

        webView.loadUrl(url!!)
        webView.webViewClient = CustomWebViewClient()
    }
}

class CustomWebViewClient : WebViewClient(){
    override fun shouldOverrideUrlLoading(
        view: WebView?,
        request: WebResourceRequest?
    ): Boolean {
        //Log.d("shouldOverrideUrlLoading", "Loading")
        return super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        //Log.d("onPageStarted", "Start")
        super.onPageStarted(view, url, favicon)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        //Log.d("onPageFinished", "Finish")
        super.onPageFinished(view, url)
    }
}