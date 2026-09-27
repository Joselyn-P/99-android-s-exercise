package com.medical.a99houselistingapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ListingDetail(
    override val id: Int,
    val address: DetailAddress,
    override val attributes: Attributes,
    val description: String,
    override val photo: String,
    @Json(name = "project_name")override val projectName: String,
    @Json(name = "property_details") val propertyDetail: List<PropertyDetail>
): ListingCommon

@JsonClass(generateAdapter = true)
data class DetailAddress(
    @Json(name = "map_coordinates") val mapCoordinates: MapCoordinates,
    val subtitle: String,
    val title: String
)

@JsonClass(generateAdapter = true)
data class MapCoordinates(
    val lat: Double,
    val lng: Double
)

@JsonClass(generateAdapter = true)
data class PropertyDetail(
    val label: String,
    val text: String
)