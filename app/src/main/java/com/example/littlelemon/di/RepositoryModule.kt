package com.example.littlelemon.di


import com.example.littlelemon.data.FirebaseDishRepository
import com.example.littlelemon.domain.DishRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
     fun providesDishRepository() : DishRepository = FirebaseDishRepository()
}