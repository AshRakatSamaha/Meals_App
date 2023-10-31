package com.example.mealsapp.domain.entity


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("idCategory")
    val idCategory: String? = null,
    @SerializedName("strCategory")
    val strCategory: String? = null,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String? = null
)