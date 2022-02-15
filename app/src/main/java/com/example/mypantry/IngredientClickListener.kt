package com.example.mypantry

import com.example.mypantry.data.model.Ingredient

interface IngredientClickListener {
    fun onIngredientClick(ingredient: Ingredient)
}