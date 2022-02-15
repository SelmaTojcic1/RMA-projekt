package com.example.mypantry.data.room

import androidx.room.*
import com.example.mypantry.data.model.Ingredient

@Dao
interface IngredientDao {

    @Query("SELECT * FROM ingredient")
    fun getIngredient(): Ingredient

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIngredient(ingredient: Ingredient)

    @Delete
    fun deleteIngredient(ingredient: Ingredient)

}