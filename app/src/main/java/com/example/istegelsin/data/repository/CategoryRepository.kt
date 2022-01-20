package com.example.istegelsin.data.repository

import com.example.istegelsin.domain.Categories
import com.example.istegelsin.domain.Product


interface CategoryRepository {

    suspend fun filterCategory(): List<Categories>
    suspend fun getProduct(subcategoryID: String?, keyword: String?): List<Product>

}