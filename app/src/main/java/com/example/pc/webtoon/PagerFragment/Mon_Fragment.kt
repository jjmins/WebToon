package com.example.pc.webtoon.PagerFragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.pc.webtoon.*
import com.example.pc.webtoon.Activity.WebToonView
import com.example.pc.webtoon.Data.WebtoonData
import com.example.pc.webtoon.Utils.Parser

import com.github.nitrico.lastadapter.BR
import com.github.nitrico.lastadapter.LastAdapter
import com.example.pc.webtoon.databinding.WebtoonItemBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_mon.view.*
import kotlinx.android.synthetic.main.webtoon_item.*
import kotlinx.android.synthetic.main.webtoon_item.view.*
import org.jetbrains.anko.support.v4.startActivity
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.github.nitrico.lastadapter.Holder


/**
 * Created by pc on 2018-01-31.
 */

class Mon_Fragment() : android.support.v4.app.Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var Mon = "http://comic.naver.com/webtoon/weekdayList.nhn?week=mon"

        var view = inflater!!.inflate(R.layout.fragment_mon, container,false)

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



        var into = LastAdapter(data,BR.data)
                .map<WebtoonData,WebtoonItemBinding>(R.layout.webtoon_item){
                    onClick{
                        var webtoonitem =it.binding.data
                        startActivity<WebToonView>("url" to webtoonitem!!.url)

                    }

                    onCreate {
                        var webtoonitem = it.binding.data
                    Glide.with(view!!.context)
                            .load(webtoonitem!!.img)
                            .apply(RequestOptions()
                                    .centerCrop()
                            )
                            .into(view.webImg)
                }
                }
                .into(view.mon_recyclerview)

        return view
    }
}
