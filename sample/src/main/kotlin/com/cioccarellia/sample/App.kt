package com.cioccarellia.sample

import android.app.Application
import android.content.Context
import com.cioccarellia.kite.Kite

class App : Application() {

    companion object {
        lateinit var appContext: Context
        val kite by Kite.fly(appContext)
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}