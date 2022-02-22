package com.example.mypantry.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypantry.R
import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.data.model.Recipe

class RecipeAdapter(): RecyclerView.Adapter<RecipeViewHolder>(){

    private var recipes = ArrayList<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return RecipeViewHolder(view)    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

}