package com.example.mypantry

import android.app.Application
import android.content.Context

class MyPantry : Application() {

    companion object {
        lateinit var context: MyPantry
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        //koin
    }
}