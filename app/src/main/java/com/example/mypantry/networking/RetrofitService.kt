package com.example.mypantry.networking

import com.example.mypantry.data.model.Recipe
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET("food/ingredients/search?query=a&apiKey=d5e5abb43ff04413b72c202719110909")
    suspend fun getAllIngredients(): IngredientsResponse

    @GET("recipes/716429/information?apiKey=d5e5abb43ff04413b72c202719110909")
    fun getRecipes(): ArrayList<Recipe>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.spoonacular.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }

}