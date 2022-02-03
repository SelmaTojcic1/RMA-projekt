package com.example.mypantry

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mypantry.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {

    private lateinit var recipesBinding: FragmentRecipesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recipesBinding = FragmentRecipesBinding.inflate(inflater, container, false)
        return recipesBinding.root
    }
}