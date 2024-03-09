package com.example.restfull_study.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.restfull_study.data.remote.api.ProductsServiceApi
import com.example.restfull_study.data.remote.model.Product
import javax.inject.Inject

class ProductsPagingSource @Inject constructor (
    private val productsServiceApi: ProductsServiceApi,
) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        TODO("Not yet implemented")
    }
}