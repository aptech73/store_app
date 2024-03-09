package com.example.restfull_study.di

import com.example.restfull_study.data.remote.api.ProductsServiceApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun provideProductServiceApi() : ProductsServiceApi {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory( Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType()) )
            .build()
            .create(ProductsServiceApi::class.java)
    }
}