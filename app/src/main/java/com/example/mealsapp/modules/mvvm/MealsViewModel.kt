package com.example.mealsapp.modules.mvvm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealsapp.domain.entity.CategoryResponse
import com.example.mealsapp.domain.usecases.GetMeals
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealsViewModel @Inject constructor(
    private val getMealsUseCases: GetMeals,
) : ViewModel() {

    private val _category: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val category: StateFlow<CategoryResponse?> = _category
    fun getMeals() {
        viewModelScope.launch {
            try {
                _category.value = getMealsUseCases()
            } catch (e: Exception) {
                Log.e("MealsViewModel", e.message.toString())
            }
        }
    }
}