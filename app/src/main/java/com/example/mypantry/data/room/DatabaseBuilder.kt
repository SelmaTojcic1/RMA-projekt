package com.example.mypantry.data.room

import androidx.room.Room
import com.example.mypantry.MyPantry

object DatabaseBuilder {

    private var instance: Database? = null

    fun getInstance(): Database{
        synchronized(Database::class){
            if(instance == null){
                instance = buildDatabase()
            }
        }
        return instance!!
    }

    private fun buildDatabase(): Database {
        return Room.databaseBuilder(
            MyPantry.context, Database::class.java, Database.NAME
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }
}