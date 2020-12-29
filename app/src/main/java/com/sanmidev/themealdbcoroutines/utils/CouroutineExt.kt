package com.sanmidev.themealdbcoroutines.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun runOnMain( block : () -> Unit){
    withContext(Dispatchers.Main){
        block.invoke()
    }
}