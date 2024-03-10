package com.example.restfull_study.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: ProductsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ListState>(ListState.Loading())
    var uiState : StateFlow<ListState> = _uiState.asStateFlow()

    val products : Flow<PagingData<Product>> = Pager(
        PagingConfig(pageSize = 20),
        pagingSourceFactory = { repository.getProductsList() }
    ).flow.cachedIn(viewModelScope)

}