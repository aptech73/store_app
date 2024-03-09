package com.example.restfull_study.domain.repository

import com.example.restfull_study.data.remote.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProductsList(skip : Long, limit : Long) : Flow<List<Product>>
}