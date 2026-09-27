package com.medical.a99houselistingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// Common attributes found in Listing and ListingDetail
interface ListingCommon {
    val id: Int
    val photo: String
    val projectName: String
    val attributes: Attributes
}

@JsonClass(generateAdapter = true)
data class Attributes(
    @Json(name = "area_size") val areaSize: Int,
    val bathrooms: Int,
    val bedrooms: Int,
    val price: Int
)