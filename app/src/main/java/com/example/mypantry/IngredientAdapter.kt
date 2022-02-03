package com.example.mypantry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypantry.databinding.AdapterIngredientBinding

class IngredientAdapter : RecyclerView.Adapter<IngredientViewHolder>() {

    private val ingredients = ArrayList<Ingredient>()

    fun setIngredientList(results: ArrayList<Ingredient>) {
        this.ingredients.addAll(results)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterIngredientBinding.inflate(inflater, parent, false)
        return IngredientViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = ingredients[position]
        holder.binding.tvIngredientName.text = ingredient.name
        Glide.with(holder.itemView.context)
//            .load(ingredient.image)
            .load("https://spoonacular.com/cdn/ingredients_100x100/apple.jpg")
            .into(holder.binding.ivIngredient)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }
}

class IngredientViewHolder(val binding: AdapterIngredientBinding) : RecyclerView.ViewHolder(binding.root) {

}