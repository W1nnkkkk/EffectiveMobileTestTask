package com.w1nkkkk.data.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class VacancyDtoModel(
    @SerializedName("lookingNumber") val lookingNumber : Int?,
    @SerializedName("title") val title : String,
    @SerializedName("address") val address: Address,
    @SerializedName("company") val company : String,
    @SerializedName("experience") val experience : Experience,
    @SerializedName("publishedDate") val publishedDate : String,
    @SerializedName("salary") val salary : Salary,
    @SerializedName("isFavorite") val isFavorite : Boolean
) {
    @Serializable
    data class Address(
        @SerializedName("town") val town : String
    )

    @Serializable
    data class Experience(
        @SerializedName("previewText") val previewText : String
    )

    @Serializable
    data class Salary(
        @SerializedName("full") val full : String
    )
}