package com.example.pc.webtoon.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.view.Menu
import android.view.MenuItem
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import com.example.pc.webtoon.Adapter.ViewPagerAdapter
import com.example.pc.webtoon.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(mainToolbar)
        var sliderlist = ArrayList<Int>()

        //val sliderin : Animation = AnimationUtils.loadAnimation(this,R.anim.slider_in)

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

        webtoonbtn.onClick {
            webtoonbtn.setBackgroundResource(R.mipmap.menu_01_webtoon_on)
            plus()
            play()
            my()
            best()

        }

        plusbtn.onClick {
            plusbtn.setBackgroundResource(R.mipmap.menu_02_plus_on)
            play()
            my()
            best()
            webtoon()
        }

        bestbtn.onClick {
           bestbtn.setBackgroundResource(R.mipmap.menu_03_best_on)
            startActivity<WebToonView>("url" to "http://comic.naver.com/genre/bestChallenge.nhn")
            plus()
            play()
            my()
            webtoon()
        }

        playbtn.onClick {
            playbtn.setBackgroundResource(R.mipmap.menu_04_get_on)
            plus()
            my()
            best()
            webtoon()
        }

        mybtn.onClick {
            mybtn.setBackgroundResource(R.mipmap.menu_05_my_on)
            plus()
            play()
            best()
            webtoon()
        }

        mainTab.addTab(mainTab.newTab().setText("월"))
        mainTab.addTab(mainTab.newTab().setText("화"))
        mainTab.addTab(mainTab.newTab().setText("수"))
        mainTab.addTab(mainTab.newTab().setText("목"))
        mainTab.addTab(mainTab.newTab().setText("금"))
        mainTab.addTab(mainTab.newTab().setText("토"))
        mainTab.addTab(mainTab.newTab().setText("일"))
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

    fun webtoon(){
        webtoonbtn.setBackgroundResource(R.mipmap.menu_01_webtoon_off)
    }
    fun plus(){
        plusbtn.setBackgroundResource(R.mipmap.menu_02_plus_off)
    }
    fun best(){
        bestbtn.setBackgroundResource(R.mipmap.menu_03_best_off)
    }
    fun play(){
        playbtn.setBackgroundResource(R.mipmap.menu_04_get_off)
    }
    fun my() {
        mybtn.setBackgroundResource(R.mipmap.menu_05_my_off)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
             R.id.search -> toast("search")
             R.id.getzzal -> toast("getzzal")
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
}
