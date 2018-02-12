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
    var MON = "mon"
    var TUE = "tue"
    var WED = "wed"
    var THU = "thu"
    var FRI = "fri"
    var SAT = "sat"
    var SUN = "sun"

    private var tabCount : Int = 0

    init{
        this.tabCount = tabCount
    }

    override fun getItem(position: Int): Fragment? {
        return when(position){
            0 -> Mon_Fragment(MON)
            1 -> Mon_Fragment(TUE)
            2 -> Mon_Fragment(WED)
            3 -> Mon_Fragment(THU)
            4 -> Mon_Fragment(FRI)
            5 -> Mon_Fragment(SAT)
            6 -> Mon_Fragment(SUN)
            7 -> Mon_Fragment("Complete")
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

}