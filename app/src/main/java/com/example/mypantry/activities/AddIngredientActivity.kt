package com.example.mypantry.activities

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mypantry.*
import com.example.mypantry.adapters.IngredientAdapter
import com.example.mypantry.data.repository.Repository
import com.example.mypantry.data.room.DatabaseBuilder
import com.example.mypantry.databinding.ActivityAddIngredientBinding
import com.example.mypantry.networking.RetrofitService
import com.example.mypantry.viewmodels.IngredientViewModel
import com.example.mypantry.viewmodels.MyViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddIngredientActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddIngredientBinding
    lateinit var viewModel: IngredientViewModel
    private val retrofitService = RetrofitService.getInstance()
    private val adapter = IngredientAdapter()
    private val ingredientDao = DatabaseBuilder.getInstance().dao()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        binding = ActivityAddIngredientBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this,
            MyViewModelFactory(Repository(retrofitService, ingredientDao))
        ).get(IngredientViewModel::class.java)

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

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as SearchView

        searchView.apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        searchView.isSubmitButtonEnabled = true

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                adapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                adapter.filter.filter(query)
                return true
            }
        })
        return true
    }
}