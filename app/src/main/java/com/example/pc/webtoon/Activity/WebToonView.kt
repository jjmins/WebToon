package com.example.pc.webtoon.Activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebViewClient
import com.example.pc.webtoon.R
import kotlinx.android.synthetic.main.webtoonview.*

/**
 * Created by pc on 2018-02-05.
 */
class WebToonView() : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webtoonview)

        var intent_ = intent
        var address = intent_.getStringExtra("url")

        webview.settings.javaScriptEnabled = true
        webview.loadUrl(address)
        webview.webViewClient = WebViewClient()
    }
}