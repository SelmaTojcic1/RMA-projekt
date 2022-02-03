package com.example.mypantry

import android.util.Log
import retrofit2.Call

class Repository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllIngredients() : IngredientsResponse {
        return retrofitService.getAllIngredients()
    }
}