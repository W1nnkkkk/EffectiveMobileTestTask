package com.w1nkkkk.domain

data class Vacancy(
    val id : Int = 0,
    val lookingNumber : Int,
    val title : String,
    val address: String,
    val company : String,
    val experience : String,
    val publishedDate : String,
    val salary : String,
    var isFavorite : Boolean
)