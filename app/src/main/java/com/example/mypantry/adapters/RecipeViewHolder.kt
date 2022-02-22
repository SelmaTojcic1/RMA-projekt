package com.example.mypantry.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypantry.data.model.Recipe
import com.example.mypantry.databinding.ItemBinding

class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(recipe: Recipe) {
        val itemRecipeBinding = ItemBinding.bind(itemView)

        itemRecipeBinding.tvItemName.text = recipe.title

        Glide.with(itemView)
            .load(recipe.image)
            .into(itemRecipeBinding.ivItem)
    }
}