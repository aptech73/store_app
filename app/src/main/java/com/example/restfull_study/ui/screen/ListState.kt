package com.example.restfull_study.ui.screen

import com.example.restfull_study.data.remote.model.Product

sealed class ListState {
    class Loading : ListState()
    class Error : ListState()
    class Success(val products : List<Product>) : ListState()
}