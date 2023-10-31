package com.example.mealsapp.data.remote

import com.example.mealsapp.domain.entity.CategoryResponse
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
   suspend fun getMeals():CategoryResponse
}