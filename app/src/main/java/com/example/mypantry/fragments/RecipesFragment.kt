package com.example.mypantry.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mypantry.adapters.RecipeAdapter
import com.example.mypantry.data.repository.Repository
import com.example.mypantry.data.room.DatabaseBuilder
import com.example.mypantry.databinding.FragmentRecipesBinding
import com.example.mypantry.networking.RetrofitService
import com.example.mypantry.viewmodels.IngredientViewModel
import com.example.mypantry.viewmodels.MyViewModelFactory
import com.example.mypantry.viewmodels.RecipeViewModel

class RecipesFragment : Fragment() {

    private lateinit var recipesBinding: FragmentRecipesBinding
    lateinit var recipeViewModel: RecipeViewModel
    private val recipeAdapter = RecipeAdapter()
    private val retrofitService = RetrofitService.getInstance()
    private val ingredientDao = DatabaseBuilder.getInstance().dao()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipesBinding = FragmentRecipesBinding.inflate(inflater, container, false)

        initViews()

        return recipesBinding.root
    }

    private fun initViews() {
        recipeViewModel = ViewModelProvider(this,
            MyViewModelFactory(Repository(retrofitService, ingredientDao))
        ).get(RecipeViewModel::class.java)

        recipesBinding.rvRecipes.adapter = recipeAdapter


    }

}