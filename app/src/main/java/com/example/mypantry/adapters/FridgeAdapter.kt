package com.example.mypantry.adapters

import android.app.AlertDialog
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mypantry.IngredientClickListener
import com.example.mypantry.R
import com.example.mypantry.data.model.Ingredient
import com.example.mypantry.data.repository.Repository
import com.example.mypantry.data.room.DatabaseBuilder
import com.example.mypantry.networking.RetrofitService

class FridgeAdapter : RecyclerView.Adapter<IngredientViewHolder>() {

    private val fridgeIngredients = ArrayList<Ingredient>()
    private val retrofitService = RetrofitService.getInstance()
    private val ingredientDao = DatabaseBuilder.getInstance().dao()
    private val repository = Repository(retrofitService, ingredientDao)
    private val ingredientClickListener: IngredientClickListener? = null

    fun setFridgeIngredientList() {
        this.fridgeIngredients.addAll(repository.getAllFridgeIngredients())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ingredient, parent, false)

        return IngredientViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val ingredient = fridgeIngredients[position]
        holder.bind(ingredient)
        holder.itemView.setOnClickListener{
            ingredientClickListener?.onIngredientClick(ingredient)
            let {
                val builder = AlertDialog.Builder(holder.itemView.context)
                builder.apply {
                    setMessage("Delete this ingredient from Fridge?")
                    setPositiveButton("Yes",
                        DialogInterface.OnClickListener { _, _ ->
                            repository.deleteIngredient(ingredient)
                            fridgeIngredients.removeAt(position)
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

    override fun getItemCount(): Int = fridgeIngredients.size
}