package com.nora.rickscrate.data.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class EpisodeBoundResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "air_date")
    val airDate: String,
    @Json(name = "episode")
    val code: String,
    @Json(name = "characters")
    val characters: List<String>,
    @Json(name = "url")
    val url: String,
    @Json(name = "created")
    val created: String
)