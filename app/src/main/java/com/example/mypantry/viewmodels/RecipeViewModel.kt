package com.example.mypantry.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypantry.data.model.Recipe
import com.example.mypantry.data.repository.Repository

class RecipeViewModel constructor(private val repository: Repository) : ViewModel() {

    val recipeList = MutableLiveData<ArrayList<Recipe>>()

    fun getRecipes() {
        recipeList.postValue(repository.getRecipes())
    }
}