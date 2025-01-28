package com.w1nkkkk.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vacancies")
data class VacancyDboModel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val lookingNumber: Int,
    val title : String,
    val address: String,
    val company : String,
    val experience : String,
    val publishedDate : String,
    val salary : String,
    val isFavorite : Boolean
)