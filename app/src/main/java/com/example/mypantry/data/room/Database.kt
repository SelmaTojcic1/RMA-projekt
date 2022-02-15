package com.example.mypantry.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mypantry.data.model.Ingredient

@Database(entities = [Ingredient::class] , version = 1)
abstract class Database : RoomDatabase() {
    abstract fun dao(): IngredientDao

    companion object{
        const val NAME = "database"
    }
}