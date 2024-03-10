package com.example.restfull_study.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.restfull_study.data.remote.api.ProductsServiceApi
import com.example.restfull_study.data.remote.model.Product
import retrofit2.HttpException
import javax.inject.Inject

class ProductsPagingSource (
    private val productsServiceApi: ProductsServiceApi,
) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        try {
            val page = params.key ?: INITIAL_PAGE_NUMBER
            val response = productsServiceApi.getProductsList( (page - 1) * 20, 20)

            if (response.isSuccessful) {
                val products = response.body()!!.products
                return LoadResult.Page(
                    data = products,
                    prevKey = if (page > 1) page - 1 else null,
                    nextKey = if (products.isEmpty()) null else page + 1
                )
            } else {
                return LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            return LoadResult.Error(e)
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

    companion object {
        const val INITIAL_PAGE_NUMBER = 1
    }
}