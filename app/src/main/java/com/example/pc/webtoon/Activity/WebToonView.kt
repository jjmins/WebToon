package com.example.pc.webtoon.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.pc.webtoon.R

/**
 * Created by pc on 2018-02-05.
 */
class WebToonView() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webtoonview)

        var intent_ = intent
        Log.e("aasdfasdfasdf",intent_.getStringExtra("url"))
    }
}