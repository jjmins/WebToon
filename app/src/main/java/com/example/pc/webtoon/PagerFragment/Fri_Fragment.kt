package com.example.pc.webtoon.PagerFragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pc.webtoon.R
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by pc on 2018-01-31.
 */
class Fri_Fragment :  android.support.v4.app.Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_mon, container, false)
    }
}