package com.example.pc.webtoon.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.example.pc.webtoon.PagerFragment.*

@Suppress("UNREACHABLE_CODE")
/**
 * Created by pc on 2018-01-31.
 */
class ViewPagerAdapter(fm: FragmentManager?,tabCount : Int) : FragmentStatePagerAdapter(fm) {

    private var tabCount : Int = 0

    init {
        this.tabCount = tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> Mon_Fragment()
            1 -> Tue_Fragment()
            2 -> Wed_Fragment()
            3 -> Thu_Fragment()
            4 -> Fri_Fragment()
            5 -> Sat_Fragment()
            6 -> Sun_Fragment()
            7 -> NewWorkFragment()
            8 -> CompleteFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}