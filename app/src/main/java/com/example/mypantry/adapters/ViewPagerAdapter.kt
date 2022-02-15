package com.example.mypantry.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.mypantry.fragments.HomeScreenFragment
import com.example.mypantry.fragments.RecipesFragment

class ViewPagerAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    companion object {
        private const val NUM_OF_FRAGMENTS = 2
    }

    override fun getItemCount() = NUM_OF_FRAGMENTS

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HomeScreenFragment()
            else -> RecipesFragment()
        }
    }
}