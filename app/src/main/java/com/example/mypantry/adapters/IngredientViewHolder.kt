package com.example.mypantry.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.databinding.ItemBinding

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(ingredient: Ingredient) {
        val itemIngredientBinding = ItemBinding.bind(itemView)
        val imageUrl = "https://spoonacular.com/cdn/ingredients_100x100/" + ingredient.image

        itemIngredientBinding.tvItemName.text = ingredient.name

        Glide.with(itemView)
            .load(imageUrl)
            .into(itemIngredientBinding.ivItem)

    }
}