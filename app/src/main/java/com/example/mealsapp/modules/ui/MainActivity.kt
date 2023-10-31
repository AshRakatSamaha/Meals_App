package com.example.mealsapp.modules.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.mealsapp.databinding.ActivityMainBinding
import com.example.mealsapp.modules.adapter.MealsAdapter
import com.example.mealsapp.modules.mvvm.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mealsViewModel: MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val rv: RecyclerView = binding.recycleView
        mealsViewModel.getMeals()
        val mealsAdapter = MealsAdapter()

        lifecycleScope.launch {
            mealsViewModel.category.collect {
                mealsAdapter.differ.submitList(it?.categories)
                rv.adapter = mealsAdapter
            }
        }
    }


}