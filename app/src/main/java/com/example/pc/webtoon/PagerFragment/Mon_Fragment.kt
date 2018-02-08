package com.example.pc.webtoon.PagerFragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import com.example.pc.webtoon.*

import com.github.nitrico.lastadapter.BR
import com.github.nitrico.lastadapter.LastAdapter
import kotlinx.android.synthetic.main.fragment_mon.*
import com.example.pc.webtoon.databinding.ActivityMainBinding
import com.example.pc.webtoon.databinding.WebtoonItemBinding
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by pc on 2018-01-31.
 */

class Mon_Fragment() : android.support.v4.app.Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var Mon = "http://comic.naver.com/webtoon/weekdayList.nhn?week=mon"
//        var Thu = ""
//        var Wed = ""
//        var  = ""
//        var mon = ""
//        var mon = ""
//        var mon = ""
//        var mon =""

//        //파싱데이터
        var parser = Parser(Mon)
        parser.start()
        parser.join()
        var data = parser.Data()

        var lm = LinearLayoutManager(context).apply {
            orientation = LinearLayoutManager.HORIZONTAL
        }//orientation = LinearLayoutManger.HoRIZONTAL(가로),VERTICAL(세로)


        recyclerview.layoutManager = GridLayoutManager(context, 2)
        //spanCount는 칸을 뜻함

        recyclerview.layoutManager = LinearLayoutManager(context)

        var into = LastAdapter(data,BR.data)
                .map<WebtoonData,WebtoonItemBinding>(R.layout.webtoon_item){
                    onClick{
                        var webtoonitem =it.binding.data

                        startActivity<WebToonView>("url" to webtoonitem!!.url)

                    }
                }
                .into(recyclerview)



        return inflater!!.inflate(R.layout.fragment_mon, container, false)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
    }
}
