package com.cioccarellia.kite

import android.content.Context

class Kite(
    applicationContext: Context
) {
    companion object {
        fun fly(applicationContext: Context) = KiteDelegate(applicationContext)
    }

}