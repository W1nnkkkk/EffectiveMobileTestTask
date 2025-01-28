package com.w1nkkkk.domain

data class Vacancy(
    val lookingNumber : Int,
    val title : String,
    val address: String,
    val company : String,
    val experience : String,
    val publishedDate : String,
    val salary : String,
    val isFavorite : Boolean
)