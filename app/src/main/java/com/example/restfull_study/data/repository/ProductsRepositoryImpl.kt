package com.example.restfull_study.data.repository

import androidx.paging.PagingSource
import com.example.restfull_study.data.remote.ProductsPagingSource
import com.example.restfull_study.data.remote.api.ProductsServiceApi
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.domain.repository.ProductsRepository
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor (
    private val productsServiceApi: ProductsServiceApi,
) : ProductsRepository {
    override fun getProductsList() : PagingSource<Int, Product> {
        return ProductsPagingSource(productsServiceApi)
    }
}