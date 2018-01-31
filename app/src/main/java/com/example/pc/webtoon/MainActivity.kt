package com.example.pc.webtoon

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.PagerAdapter
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TabHost
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import com.example.pc.webtoon.Adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.viewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(mainToolbar)
        var sliderlist = ArrayList<Int>()

        sliderlist.add(R.drawable.sliderone)
        sliderlist.add(R.drawable.slidertwo)
        sliderlist.add(R.drawable.sliderthree)
        sliderlist.add(R.drawable.sliderfour)
        sliderlist.add(R.drawable.sliderfive)
        sliderlist.add(R.drawable.slidersix)
        sliderlist.add(R.drawable.sliderseven)
        sliderlist.add(R.drawable.slidereight)
        sliderlist.add(R.drawable.slidernight)

        for (i in 0 until sliderlist.size) {
            val DefaultSliderView = DefaultSliderView(this)

            DefaultSliderView
                    .image(sliderlist[i])
            mainTabSlider.addSlider(DefaultSliderView)
        }

        mainTab.addTab(mainTab.newTab().setText("월"))
        mainTab.addTab(mainTab.newTab().setText("화"))
        mainTab.addTab(mainTab.newTab().setText("수"))
        mainTab.addTab(mainTab.newTab().setText("목"))
        mainTab.addTab(mainTab.newTab().setText("금"))
        mainTab.addTab(mainTab.newTab().setText("토"))
        mainTab.addTab(mainTab.newTab().setText("일"))
        mainTab.addTab(mainTab.newTab().setText("신작"))
        mainTab.addTab(mainTab.newTab().setText("완결"))
        mainTab.tabGravity = TabLayout.GRAVITY_FILL

        val pageradapter = ViewPagerAdapter(supportFragmentManager, mainTab.tabCount)
        mainPager.adapter = pageradapter

        mainPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(mainTab))


        mainTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                    mainPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })

    }



//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//            return super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu,menu)
//        return true
//    }
}
