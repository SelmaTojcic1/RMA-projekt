package com.example.mypantry

import com.example.mypantry.model.Ingredient

interface IngredientClickListener {
    fun onItemClick(ingredient: Ingredient)
}