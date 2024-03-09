package com.example.restfull_study.data.repository

import com.example.restfull_study.data.remote.api.ProductsServiceApi
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api : ProductsServiceApi
): ProductsRepository {
    override fun getProductsList(skip: Long, limit: Long): Flow<List<Product>> = flow {
        emit( api.getProductsList(skip, limit).products )
    }
}