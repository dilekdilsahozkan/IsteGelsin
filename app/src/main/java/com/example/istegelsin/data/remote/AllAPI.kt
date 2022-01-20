package com.example.istegelsin.data.remote

import com.example.istegelsin.domain.Product
import retrofit2.Response
import retrofit2.http.*

interface AllAPI {

    @GET("/market/category/template")
    suspend fun getMethod(): Response<CategoryResponse>

    @POST("/market/product/template")
    suspend fun postMethod(@Body productBody: ProductBody) : Response<ProductResponse>
}
