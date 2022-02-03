package com.example.mypantry

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypantry.databinding.ItemIngredientBinding

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(ingredient: Ingredient) {
        val itemIngredientBinding = ItemIngredientBinding.bind(itemView)

        itemIngredientBinding.tvIngredientName.text = ingredient.name

        Glide.with(itemView)
//            .load(ingredient.image)
            .load("https://spoonacular.com/cdn/ingredients_100x100/apple.jpg")
            .into(itemIngredientBinding.ivIngredient)

    }
}