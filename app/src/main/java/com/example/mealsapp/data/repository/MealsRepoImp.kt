package com.example.mealsapp.data.repository

import com.example.mealsapp.data.remote.ApiService
import com.example.mealsapp.domain.entity.CategoryResponse
import com.example.mealsapp.domain.repo.MealsRepository

class MealsRepoImp(private val apiService: ApiService) : MealsRepository {
    override suspend fun getMealsFromRemote(): CategoryResponse = apiService.getMeals()
}