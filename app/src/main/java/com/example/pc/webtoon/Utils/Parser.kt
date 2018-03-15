package com.example.pc.webtoon.Utils

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import com.example.pc.webtoon.Data.WebtoonData


/**
 * Created by pc on 2018-02-04.
 */

class Parser(var url : String) : Thread() {
    var count = 1
    var items = ArrayList<WebtoonData>()
    private var uri = ""
    init {
        this.uri = url
    }


    override fun run() {
        super.run()
        var document: org.jsoup.nodes.Document? = Jsoup.connect(uri).get()

//        for (element in col_selected) {
//            items.add(Item(element.select("a").attr("title"), element.select("a").select("img").attr("src"), element.select(".desc").text()))
//        }
        print(document.toString())

            var info: Elements = document!!.select("div.lst")

            for(element in info){
                items.add(WebtoonData(element.select("a").select("span")
                        .select("span").select("img").attr("src"),
                        element.select("a").select("span")
                                .select("span").select("img").attr("alt"),
                        element.select("a").select("p").text(),
                        element.select("a").select("div.toon_detail_info")
                                .select("span.txt_score").text(),
                        "http://comic.naver.com/" + element.select("a").attr("href")))
                }
            }

    fun Data() : ArrayList<WebtoonData> {
        return items
    }
}