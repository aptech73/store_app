package com.example.restfull_study.domain.repository

import androidx.paging.PagingSource
import com.example.restfull_study.data.remote.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    fun getProductsList() : PagingSource<Int, Product>
}