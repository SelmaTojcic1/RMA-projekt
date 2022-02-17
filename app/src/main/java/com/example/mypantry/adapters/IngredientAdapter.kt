package com.example.mypantry.adapters

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mypantry.IngredientClickListener
import com.example.mypantry.R
import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.data.repository.Repository
import com.example.mypantry.data.room.DatabaseBuilder
import com.example.mypantry.networking.RetrofitService
import kotlin.collections.ArrayList


class IngredientAdapter() : RecyclerView.Adapter<IngredientViewHolder>(), Filterable  {

    private val ingredients = ArrayList<Ingredient>()
    private var filteredIngredients = ArrayList<Ingredient>()
    private val ingredientClickListener: IngredientClickListener? = null

    private val retrofitService = RetrofitService.getInstance()
    private val ingredientDao = DatabaseBuilder.getInstance().dao()
    private val repository = Repository(retrofitService, ingredientDao)

    fun setIngredientList(results: ArrayList<Ingredient>) {
        for(result in results) {
            if(!this.ingredients.contains(result)) {
                this.ingredients.add(result)
            }
        }
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
            ingredientClickListener?.onIngredientClick(ingredient)
            let {
                val builder = AlertDialog.Builder(holder.itemView.context)
                builder.apply {
                    setMessage("Add this ingredient to Fridge?")
                    setPositiveButton("Yes",
                        DialogInterface.OnClickListener { _, _ ->
                            repository.insertIngredient(ingredient)
                            notifyDataSetChanged()
                        })
                    setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { _, _ ->
                        })
                }
                builder.create()
            }?.show()
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
