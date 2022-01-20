package com.example.istegelsin.data.local.entity


import com.example.istegelsin.domain.Categories
import com.example.istegelsin.domain.Entity

data class CategoryEntity(
    val categories: List<Categories>
): Entity()
