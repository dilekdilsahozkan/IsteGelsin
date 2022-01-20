package com.example.istegelsin.domain


data class Categories(

    var id: String? = null,
    var parentCategoryID: String? = null,
    var name: String? = null,
    var subcategories: List<Categories>? = null

) : Entity()
