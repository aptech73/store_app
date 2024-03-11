package com.example.restfull_study.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id : Long,
    val title : String,
    val description : String,
    val thumbnail : String,
    val price : Long
)

//      {
//        "id": 1,
//        "title": "iPhone 9",
//        "description": "An apple mobile which is nothing like apple",
//        "price": 549,
//        "discountPercentage": 12.96,
//        "rating": 4.69,
//        "stock": 94,
//        "brand": "Apple",
//        "category": "smartphones",
//        "thumbnail": "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
//        "images": [
//        "https://cdn.dummyjson.com/product-images/1/1.jpg",
//        "https://cdn.dummyjson.com/product-images/1/2.jpg",
//        "https://cdn.dummyjson.com/product-images/1/3.jpg",
//        "https://cdn.dummyjson.com/product-images/1/4.jpg",
//        "https://cdn.dummyjson.com/product-images/1/thumbnail.jpg"
//        ]
//    }