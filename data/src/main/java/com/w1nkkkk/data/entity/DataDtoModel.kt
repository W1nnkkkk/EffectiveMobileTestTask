package com.w1nkkkk.data.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class DataDtoModel(
    @SerializedName("offers") val offers : List<OfferDtoModel>,
    @SerializedName("vacancies") val vacancies : List<VacancyDtoModel>
)
