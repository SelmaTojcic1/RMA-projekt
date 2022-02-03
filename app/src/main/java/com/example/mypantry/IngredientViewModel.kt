package com.example.mypantry

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class IngredientViewModel constructor(private val repository: Repository) : ViewModel() {

    val ingredientList = MutableLiveData<IngredientsResponse>()

    suspend fun getAllIngredients() {
        ingredientList.postValue(repository.getAllIngredients())
    }

}