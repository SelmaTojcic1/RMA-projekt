package com.example.mypantry.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mypantry.adapters.ViewPagerAdapter
import com.example.mypantry.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var bindingMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)

        val viewPager = bindingMain.viewPager
        val tabLayout = bindingMain.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Fridge"
                else -> "Recipes"
            }
        }.attach()
    }
}