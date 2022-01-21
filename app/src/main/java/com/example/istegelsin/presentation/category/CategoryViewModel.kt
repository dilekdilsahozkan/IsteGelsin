package com.example.istegelsin.presentation.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.istegelsin.data.local.entity.CategoryEntity
import com.example.istegelsin.domain.AllUseCase
import com.example.istegelsin.domain.BaseResult
import com.example.istegelsin.domain.Categories
import com.example.istegelsin.domain.Product
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CategoryViewModel (private val homeUseCase: AllUseCase): ViewModel() {
    private val _homeState: MutableStateFlow<HomeUIState> = MutableStateFlow(HomeUIState.Idle)
    val homeState: StateFlow<HomeUIState> = _homeState

    fun getLists(){
        viewModelScope.launch {
            homeUseCase.getAllProduct()
                .onStart {
                    _homeState.value = HomeUIState.Loading
                }
                .catch { exception ->
                    _homeState.value = HomeUIState.Error(exception.message)
                }
                .collect { baseResult ->
                    when(baseResult){
                        is BaseResult.Success -> _homeState.value = HomeUIState.PageSuccess(baseResult.data)
                    }
                }
        }
    }

    fun getProducts(subcategoryID : String?, keyword: String?) {
        viewModelScope.launch {
            homeUseCase.getProducts(subcategoryID , keyword)
                .onStart {
                    _homeState.value = HomeUIState.Loading
                }
                .catch { exception ->
                    _homeState.value = HomeUIState.Error(exception.message)
                }
                .collect { baseResult ->
                    when(baseResult){
                        is BaseResult.Success -> _homeState.value = HomeUIState.ProductSuccess(baseResult.data)
                    }
                }
        }
    }


}

sealed class HomeUIState{

    data class Error(val error: String?): HomeUIState()
    //data class Success(val searchEntity: List<Product>): HomeUIState()
    data class PageSuccess(val categoryList:List<Categories>): HomeUIState()
    data class ProductSuccess(val productList:List<Product>): HomeUIState()
    object Idle: HomeUIState()
    object Loading: HomeUIState()
}