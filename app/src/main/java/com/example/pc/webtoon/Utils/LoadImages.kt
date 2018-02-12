package com.example.pc.webtoon.Utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

/**
 * Created by pc on 2018-02-10.
 */
class LoadImages(var images : String) : Thread(){
    private var image = ""
    var img : Drawable? = null
    var bitmap : Bitmap? = null
    init {
        image = images
    }

    override fun run() {
        super.run()

        val url = URL(image)

        // Web에서 이미지를 가져온 뒤
        // ImageView에 지정할 Bitmap을 만든다
        val conn = url.openConnection() as HttpURLConnection
        conn.doInput = true // 서버로 부터 응답 수신
        conn.connect()

        val is_ : InputStream = conn.inputStream // InputStream 값 가져오기
        bitmap = BitmapFactory.decodeStream(is_) // Bitmap으로 변환

    }

    fun getimg() : Bitmap? {
        return this!!.bitmap
    }

}