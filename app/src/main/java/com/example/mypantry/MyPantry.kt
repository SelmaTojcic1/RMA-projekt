package com.example.mypantry

import android.app.Application
import android.content.Context

class MyPantry : Application() {

    companion object {
        lateinit var application: MyPantry
    }

    override fun onCreate() {
        super.onCreate()
        application = this@MyPantry
        //koin
    }
}