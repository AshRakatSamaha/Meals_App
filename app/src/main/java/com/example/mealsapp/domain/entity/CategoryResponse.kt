package com.example.mealsapp.domain.entity


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories")
    val categories: List<Category?>? = null
)