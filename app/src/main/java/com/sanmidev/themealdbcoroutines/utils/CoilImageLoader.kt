package com.sanmidev.themealdbcoroutines.utils

import android.widget.ImageView
import coil.load

object CoilImageLoader : ImageLoader {

    override fun loadImage(view: ImageView, imageUrl: String,) {
        view.load(imageUrl) {
            crossfade(true)
        }
    }
}