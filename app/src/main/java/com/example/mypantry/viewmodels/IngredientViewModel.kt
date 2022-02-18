package com.example.mypantry.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.networking.IngredientsResponse
import com.example.mypantry.data.repository.Repository

class IngredientViewModel constructor(private val repository: Repository) : ViewModel() {

    val ingredientList = MutableLiveData<IngredientsResponse>()
    val fridgeIngredientList = MutableLiveData<List<Ingredient>>()

    suspend fun getAllIngredients() {
        ingredientList.postValue(repository.getAllIngredients())
    }

    fun getFridgeIngredients() {
        fridgeIngredientList.postValue(repository.getAllFridgeIngredients())
    }
}