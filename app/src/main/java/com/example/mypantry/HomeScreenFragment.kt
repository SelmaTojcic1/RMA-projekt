package com.example.mypantry

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mypantry.databinding.FragmentHomeScreenBinding


class HomeScreenFragment : Fragment() {

    private lateinit var homeScreenBinding: FragmentHomeScreenBinding

    companion object {
        const val TAG = "Ingredients list"
        fun create(): HomeScreenFragment {
            return HomeScreenFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeScreenBinding =
            FragmentHomeScreenBinding.inflate(inflater, container, false)

//        setupRecyclerView()

        return homeScreenBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeScreenBinding.btnOpenAddIngredientFragment.setOnClickListener{
            startActivity(Intent(requireContext(),AddIngredientActivity::class.java))
        }
    }

//    override fun onResume() {
//        super.onResume()
//        (homeScreenBinding.rvIngredients.adapter as IngredientsAdapter)
//            .refreshData(ingredientsRepository.getIngredients())
//    }
//
//    private fun setupRecyclerView() {
//        homeScreenBinding.rvIngredients.layoutManager = LinearLayoutManager (
//            context, LinearLayoutManager.VERTICAL, false)
//
//        homeScreenBinding.rvIngredients.adapter =
//            IngredientsAdapter(ingredientsRepository.getIngredients())
//
//    }

}