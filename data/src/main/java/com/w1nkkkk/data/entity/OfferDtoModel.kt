package com.w1nkkkk.data.entity

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

@Serializable
data class OfferDtoModel(
   @SerializedName("id") val id : String?,
   @SerializedName("title") val title : String,
   @SerializedName("link") val link : String,
   @SerializedName("button") val button: JsonObject?
)
