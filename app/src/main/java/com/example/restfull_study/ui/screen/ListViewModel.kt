package com.example.restfull_study.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.restfull_study.data.remote.model.Product
import com.example.restfull_study.domain.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
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

    init {
        viewModelScope.launch {
            repository.getProductsList(0, 100).collect {
                _uiState.value = ListState.Success(it)
            }
        }
    }

}