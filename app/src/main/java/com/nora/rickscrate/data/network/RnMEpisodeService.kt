package com.nora.rickscrate.data.network

import com.nora.rickscrate.data.model.EpisodeBoundResponse
import com.nora.rickscrate.data.model.EpisodeResponse
import com.nora.rickscrate.data.model.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RnMEpisodeService {

    @GET("episode/")
    suspend fun fetchEpisodesResponse(@Query("page") page: Int): Response<PageResponse<EpisodeResponse>>

    @GET("episode/{episodes}")
    suspend fun fetchMultipleEpisodesResponse(@Path("episodes") episodes: List<String>): Response<List<EpisodeBoundResponse>>
}