package com.example.restfull_study.data.remote.api

import com.example.restfull_study.data.remote.model.NetworkResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsServiceApi {

    @GET("/products")
    suspend fun getProductsList(
        @Query("skip") skip : Int,
        @Query("limit") limit : Int
    ) : Response<NetworkResponse>

}