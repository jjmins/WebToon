package com.example.pc.webtoon

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.widget.NestedScrollView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.daimajia.slider.library.SliderTypes.DefaultSliderView
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.onScrollChange

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
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
            return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
}
