package com.sanmidev.themealdbcoroutines.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface ImageLoader {
    fun loadImage (view : ImageView, imageUrl : String)
}