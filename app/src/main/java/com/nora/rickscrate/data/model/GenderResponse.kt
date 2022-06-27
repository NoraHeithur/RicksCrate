package com.nora.rickscrate.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

enum class GenderResponse(val gender: String) {
    @Json(name = "Male")
    MALE("Male"),

    @Json(name = "Female")
    FEMALE("Female"),

    @Json(name = "Genderless")
    GENDERLESS("Genderless"),

    @Json(name = "unknown")
    UNKNOWN("Unknown");

    override fun toString(): String = gender
}
