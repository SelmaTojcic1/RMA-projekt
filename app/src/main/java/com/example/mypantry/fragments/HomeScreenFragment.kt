package com.example.mypantry.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypantry.activities.AddIngredientActivity
import com.example.mypantry.adapters.FridgeAdapter
import com.example.mypantry.data.repository.Repository
import com.example.mypantry.data.room.DatabaseBuilder
import com.example.mypantry.databinding.FragmentHomeScreenBinding
import com.example.mypantry.networking.RetrofitService
import com.example.mypantry.viewmodels.IngredientViewModel
import com.example.mypantry.viewmodels.MyViewModelFactory
import android.app.Activity
import androidx.fragment.app.FragmentTransaction


class HomeScreenFragment : Fragment() {

    private lateinit var homeScreenBinding: FragmentHomeScreenBinding
    lateinit var viewModel: IngredientViewModel
    private val fridgeAdapter = FridgeAdapter()
    private val retrofitService = RetrofitService.getInstance()
    private val ingredientDao = DatabaseBuilder.getInstance().dao()

    companion object {
        const val TAG = "Ingredients_list"
        fun create(): HomeScreenFragment {
            return HomeScreenFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeScreenBinding =
            FragmentHomeScreenBinding.inflate(inflater, container, false)

        initViews()

        return homeScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenBinding.btnOpenAddIngredientFragment.setOnClickListener{
            startActivity(Intent(requireContext(), AddIngredientActivity::class.java))
        }
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this,
            MyViewModelFactory(Repository(retrofitService, ingredientDao))
        ).get(IngredientViewModel::class.java)

        homeScreenBinding.rvIngredientsHome.adapter = fridgeAdapter

        homeScreenBinding.rvIngredientsHome.layoutManager = LinearLayoutManager (
            requireContext(), LinearLayoutManager.VERTICAL, false)

        viewModel.fridgeIngredientList.observe(requireActivity(), {
            fridgeAdapter.setFridgeIngredientList()
        })

        viewModel.getFridgeIngredients()
    }
}