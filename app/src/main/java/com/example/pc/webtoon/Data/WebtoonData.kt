package com.example.pc.webtoon.Data

import android.databinding.BindingAdapter
import android.graphics.Color
import android.view.View
import com.bumptech.glide.Glide
import android.graphics.BitmapFactory
import android.R.attr.bitmap
import android.graphics.Bitmap
import com.example.pc.webtoon.Utils.LoadImages
import android.R.attr.bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable


/**
 * Created by pc on 2018-02-05.
 */
class WebtoonData(var img : String, var name :String,var author : String,var grade : String ,var url : String){

    fun setimg() : Any{
        var image = LoadImages(img)
        image.start()
        image.join()
        var d = image.getimg()
        val data : Drawable = BitmapDrawable(d)
        return data!!
    }

}