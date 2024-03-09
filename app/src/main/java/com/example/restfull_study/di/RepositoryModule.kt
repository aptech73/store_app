package com.example.restfull_study.di

import com.example.restfull_study.data.repository.ProductsRepositoryImpl
import com.example.restfull_study.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideProductRepository(
        productsRepositoryImpl: ProductsRepositoryImpl
    ) : ProductsRepository

}