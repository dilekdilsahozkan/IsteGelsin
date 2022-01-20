package com.example.istegelsin.domain

data class Product(

var id: String? = null,
var name: String? = null,
var imageUrl: String? = null,
var stock: Int? = null,
var price: Int? = null,
var promotionDiscountPercentage: Int? = null,

): Entity()
