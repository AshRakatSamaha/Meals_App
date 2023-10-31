package com.example.mealsapp.modules.di

import com.example.mealsapp.domain.repo.MealsRepository
import com.example.mealsapp.domain.usecases.GetMeals
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCases(mealsRepository: MealsRepository):GetMeals{
        return GetMeals(mealsRepository)
    }
}