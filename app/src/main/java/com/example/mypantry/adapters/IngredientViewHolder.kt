package com.example.mypantry.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypantry.databinding.ItemIngredientBinding
import com.example.mypantry.model.Ingredient

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(ingredient: Ingredient) {
        val itemIngredientBinding = ItemIngredientBinding.bind(itemView)
        val imageUrl = "https://spoonacular.com/cdn/ingredients_100x100/" + ingredient.image

        itemIngredientBinding.tvIngredientName.text = ingredient.name

        Glide.with(itemView)
            .load(imageUrl)
            .into(itemIngredientBinding.ivIngredient)

    }
}