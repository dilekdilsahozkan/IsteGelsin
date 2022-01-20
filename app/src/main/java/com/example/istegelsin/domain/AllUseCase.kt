package com.example.istegelsin.domain

import com.example.istegelsin.data.remote.CategoryResponse
import com.example.istegelsin.data.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AllUseCase( private val categoryRepository: CategoryRepository)  {

    fun getAllProduct(): Flow<BaseResult<List<Categories>, CategoryResponse>>{
        return flow {
            emit(
                BaseResult.Success(
                    categoryRepository.filterCategory()
                )
            )
        }
    }

    fun getProducts(subcategoryID:String?, keyword: String?): Flow<BaseResult<List<Product>, CategoryResponse>>{
        return flow {
            emit(
                BaseResult.Success(
                    categoryRepository.getProduct(subcategoryID  , keyword)
                )
            )
        }
    }


}