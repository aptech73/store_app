package com.example.restfull_study.data.remote.model

import kotlinx.serialization.Serializable


@Serializable
data class NetworkResponse (
    val products : List<Product>,
    val total : Long,
    val skip : Long,
    val limit : Long
)