package com.example.mypantry


class Repository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllIngredients() : IngredientsResponse {
        return retrofitService.getAllIngredients()
    }
}