package com.example.istegelsin.data.repository


import com.example.istegelsin.data.remote.AllAPI
import com.example.istegelsin.data.remote.ProductBody
import com.example.istegelsin.domain.Categories
import com.example.istegelsin.domain.Product

class CategoryRepositoryImpl (private var allApi: AllAPI): CategoryRepository {


    override suspend fun filterCategory(): List<Categories> {


        val response = allApi.getMethod()

        if (response.isSuccessful) {

            return response.body()?.data?.map {
                Categories(
                    id = it.id,
                    parentCategoryID = it.parentCategoryID,
                    name = it.name,
                    subcategories = it.subcategories
                )
            } ?: listOf()

        }
        return listOf()
    }


    override suspend fun getProduct(subcategoryID: String?, keyword: String?): List<Product> {
        var postMethodData = ProductBody("${subcategoryID}","${keyword}")
        val response = allApi.postMethod(postMethodData)

        if (response.isSuccessful){
            return response.body()?.data?.map {
                Product(
                    id = it.id,
                    name = it.name,
                    imageUrl = it.imageUrl,
                    price = it.price ?: 0.0,
                    promotionDiscountPercentage = it.promotionDiscountPercentage
                )
            }?: listOf()
        }
        return listOf()
    }

}