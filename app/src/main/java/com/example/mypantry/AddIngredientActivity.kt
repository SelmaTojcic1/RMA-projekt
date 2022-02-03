package com.example.mypantry

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypantry.databinding.ActivityAddIngredientBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddIngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddIngredientBinding
    lateinit var viewModel: IngredientViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = IngredientAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityAddIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            MyViewModelFactory(Repository(retrofitService))).get(IngredientViewModel::class.java)

        binding.rvIngredients.adapter = adapter

        binding.rvIngredients.layoutManager = LinearLayoutManager (
            this, LinearLayoutManager.VERTICAL, false)

        viewModel.ingredientList.observe(this, Observer {
            adapter.setIngredientList(it.results)
        })

        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getAllIngredients()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }
}