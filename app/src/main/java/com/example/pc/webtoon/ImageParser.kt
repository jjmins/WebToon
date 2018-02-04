package com.example.pc.webtoon

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document
import org.w3c.dom.Element

/**
 * Created by pc on 2018-02-04.
 */

class ImageParser : Thread() {
    private var url = "http://comic.naver.com/webtoon/weekdayList.nhn?week=mon"
    var k = 0
    var img = ArrayList<String>()
    var header = ArrayList<String>()

    override fun run() {
        super.run()
        var document: org.jsoup.nodes.Document? = Jsoup.connect(url).get()

//    while(true){
//
//        var count : Elements? = document!!.select("span.im_inbr").eq(i)
//        i++
//        if(count==null){
//            Log.e("count",i.toString())
//            break
//        }
//    }
        for (i in 1..28) {
            var info : Elements = document!!.select("span.im_inbr").select("img").eq(i)

            img.add(info!!.attr("src"))
            header.add(info!!.attr("alt"))



        }
        print(document.toString())
        for(i in 0..img.size-1){
            Log.e("파싱", img[i])
            Log.e("이름", header[i])
        }
    }
}