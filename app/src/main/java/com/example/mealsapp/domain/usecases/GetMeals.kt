package com.example.mealsapp.domain.usecases

import com.example.mealsapp.domain.repo.MealsRepository

class GetMeals(private val mealsRepository: MealsRepository) {
    suspend operator fun invoke() = mealsRepository.getMealsFromRemote()
}