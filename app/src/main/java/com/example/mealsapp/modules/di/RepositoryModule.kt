package com.example.mealsapp.modules.di

import com.example.mealsapp.data.remote.ApiService
import com.example.mealsapp.data.repository.MealsRepoImp
import com.example.mealsapp.domain.repo.MealsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(apiService: ApiService):MealsRepository{
        return MealsRepoImp(apiService)
    }
}