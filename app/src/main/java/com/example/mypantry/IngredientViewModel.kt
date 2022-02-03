package com.example.mypantry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IngredientViewModel constructor(private val repository: Repository) : ViewModel() {

    val ingredientList = MutableLiveData<IngredientsResponse>()
    val errorMessage = MutableLiveData<String>()

    suspend fun getAllIngredients() {
        ingredientList.postValue(repository.getAllIngredients())
        Log.d("nestonesto", "neenenene")
    }

}