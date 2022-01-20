package com.example.istegelsin.data.remote

import com.example.istegelsin.domain.Categories
import com.google.gson.annotations.SerializedName

data class CategoryDTO(
    @SerializedName("id") var id: String? = null,
    @SerializedName("parentCategoryID") var parentCategoryID: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("subcategories") var subcategories: List<Categories>?
)
