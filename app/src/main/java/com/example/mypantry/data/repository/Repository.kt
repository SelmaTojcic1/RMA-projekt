package com.example.mypantry.data.repository

import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.data.room.IngredientDao
import com.example.mypantry.networking.IngredientsResponse
import com.example.mypantry.networking.RetrofitService


class Repository constructor(private val retrofitService: RetrofitService,
                             private val ingredientDao: IngredientDao) {

    suspend fun getAllIngredients() : IngredientsResponse {
        return retrofitService.getAllIngredients()
    }

    fun getAllFridgeIngredients() : List<Ingredient> {
        return ingredientDao.getIngredients()
    }

    fun insertIngredient(ingredient: Ingredient) {
        ingredientDao.insertIngredient(ingredient)
    }

    fun deleteIngredient(ingredient: Ingredient) {
        ingredientDao.deleteIngredient(ingredient)
    }
}