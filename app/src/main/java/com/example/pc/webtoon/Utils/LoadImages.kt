package com.example.pc.webtoon.Utils

import android.graphics.drawable.Drawable
import java.io.InputStream
import java.net.URL

/**
 * Created by pc on 2018-02-10.
 */
class LoadImages(var images : String) : Thread(){
    private var image = ""
    var img : Drawable? = null

    init {
        image = images
    }

    override fun run() {
        super.run()
        var Is : InputStream = URL(image).getContent() as InputStream
        img = Drawable.createFromStream(Is,"asdf")
    }

    fun getimg() : Drawable? {
        return this!!.img
    }

}