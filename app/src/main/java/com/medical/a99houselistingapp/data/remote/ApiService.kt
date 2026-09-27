package com.medical.a99houselistingapp.data.remote

import com.medical.a99houselistingapp.data.model.Listing
import com.medical.a99houselistingapp.data.model.ListingDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("listings.json")
    suspend fun getListings(): List<Listing>

    @GET("details/{id}.json")
    suspend fun getListingDetail(@Path("id") id: Int): ListingDetail
}