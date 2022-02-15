package com.example.mypantry.data

import com.example.mypantry.networking.IngredientsResponse
import com.example.mypantry.networking.RetrofitService


class Repository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllIngredients() : IngredientsResponse {
        return retrofitService.getAllIngredients()
    }
}