package com.example.istegelsin.domain

data class Product(

var id: String? = null,
var name: String? = null,
var imageUrl: String? = null,
var price: Double = 0.0,
var promotionDiscountPercentage: Double? = null,

): Entity()
