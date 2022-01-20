package com.example.istegelsin.data.remote

import com.google.gson.annotations.SerializedName

data class ProductDTO(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("stock") val stock: Int? = null,
    @SerializedName("price") val price: Int? = null,
    @SerializedName("promotionDiscountPercentage") val promotionDiscountPercentage: Int? = null,
)
