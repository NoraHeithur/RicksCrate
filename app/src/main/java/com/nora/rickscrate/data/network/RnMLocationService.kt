package com.nora.rickscrate.data.network

import com.nora.rickscrate.data.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RnMLocationService {

    @GET("location/")
    suspend fun fetchLocationsResponse(@Query("page") page: Int): Response<PageResponse<LocationResponse>>
}