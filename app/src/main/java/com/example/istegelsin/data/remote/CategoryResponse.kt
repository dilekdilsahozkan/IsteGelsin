package com.example.istegelsin.data.remote

import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("data") var data: List<CategoryDTO>? = null
)
data class ProductResponse(
    @SerializedName("data") var data: List<ProductDTO>? = null

)
