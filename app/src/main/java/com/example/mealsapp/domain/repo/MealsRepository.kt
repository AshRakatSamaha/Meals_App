package com.example.mealsapp.domain.repo

import com.example.mealsapp.domain.entity.CategoryResponse

interface MealsRepository {
   suspend fun getMealsFromRemote():CategoryResponse
}