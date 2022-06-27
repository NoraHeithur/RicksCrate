package com.nora.rickscrate.data.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class CharacterResponse(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "status")
    val statusResponse: StatusResponse,
    @Json(name = "species")
    val species: String,
    @Json(name = "type")
    val type: String,
    @Json(name = "gender")
    val genderResponse: GenderResponse,
    @Json(name = "origin")
    val originResponse: OriginResponse,
    @Json(name = "location")
    val lastAppearance: LastEndpoint,
    @Json(name = "image")
    val image: String,
    @Json(name = "episode")
    val episode: List<String>,
    @Json(name = "url")
    val characterEndpoint: String,
    @Json(name = "created")
    val created: String
)