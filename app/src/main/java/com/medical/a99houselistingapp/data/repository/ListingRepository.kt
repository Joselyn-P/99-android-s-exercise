package com.medical.a99houselistingapp.data.repository

import com.medical.a99houselistingapp.data.model.Listing
import com.medical.a99houselistingapp.data.model.ListingDetail
import com.medical.a99houselistingapp.data.remote.RetrofitInstance

class ListingRepository {
    suspend fun getListings(): List<Listing> = RetrofitInstance.api.getListings()
    suspend fun getListingDetail(id: Int): ListingDetail = RetrofitInstance.api.getListingDetail(id)
}