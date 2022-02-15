package com.example.mypantry.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.mypantry.IngredientClickListener
import com.example.mypantry.R
import com.example.mypantry.model.Ingredient
import kotlin.collections.ArrayList


class IngredientAdapter() : RecyclerView.Adapter<IngredientViewHolder>(), Filterable  {

    private val ingredients = ArrayList<Ingredient>()
    private var filteredIngredients = ArrayList<Ingredient>()
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
        val ingredient = filteredIngredients[position]
        holder.bind(ingredient)
        holder.itemView.setOnClickListener{
            ingredientClickListener?.onItemClick(ingredient)
            //add to database, show on home screen fragment
        }
    }

    override fun getItemCount(): Int = filteredIngredients.size


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                filteredIngredients = if (charString.isEmpty()) {
                    ingredients
                } else {
                    val filteredList: ArrayList<Ingredient> = ArrayList()
                    for (ingredient in ingredients) {
                        if(ingredient.name.lowercase().contains(charString.lowercase())) {
                            filteredList.add(ingredient)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = filteredIngredients
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredIngredients = filterResults.values as ArrayList<Ingredient>
                notifyDataSetChanged()
            }
        }
    }

}
