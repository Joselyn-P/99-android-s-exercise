package com.medical.a99houselistingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Listing(
    override val id: Int,
    val address: Address,
    override val attributes: Attributes,
    val category: String,
    @Json(name = "completed_at") val completedAt: String,
    override val photo: String,
    @Json(name = "project_name") override val projectName: String,
    val tenure: Int
): ListingCommon

@JsonClass(generateAdapter = true)
data class Address(
    val district: String,
    @Json(name = "street_name") val streetName: String
)

