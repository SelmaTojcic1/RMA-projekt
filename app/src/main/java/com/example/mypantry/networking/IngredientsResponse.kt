package com.example.mypantry.networking

import com.example.mypantry.model.Ingredient

data class IngredientsResponse (
    val results: ArrayList<Ingredient>)