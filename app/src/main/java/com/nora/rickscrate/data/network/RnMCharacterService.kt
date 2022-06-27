package com.nora.rickscrate.data.network

import com.nora.rickscrate.data.model.CharacterResponse
import com.nora.rickscrate.data.model.PageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RnMCharacterService {

    @GET("character/")
    suspend fun fetchCharactersResponse(@Query("page") page: Int): Response<PageResponse<CharacterResponse>>
}