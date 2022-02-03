package com.example.mypantry

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class IngredientAdapter : RecyclerView.Adapter<IngredientViewHolder>() {

    private val ingredients = ArrayList<Ingredient>()
    private val filteredIngredients = ArrayList<Ingredient>()
    private val ingredientClickListener: IngredientClickListener? = null

    fun setIngredientList(results: ArrayList<Ingredient>) {
        this.ingredients.addAll(results)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)

        return IngredientViewHolder(view)

    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = ingredients[position]
        holder.bind(ingredient)
        holder.itemView.setOnClickListener{
            ingredientClickListener?.onItemClick(ingredient)
        }
    }

    override fun getItemCount(): Int = ingredients.size
}
