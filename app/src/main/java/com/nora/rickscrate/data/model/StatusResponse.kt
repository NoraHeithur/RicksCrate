package com.nora.rickscrate.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

enum class StatusResponse(val status: String) {
    @Json(name = "Alive")
    ALIVE("Alive"),

    @Json(name = "Dead")
    DEAD("Dead"),

    @Json(name = "unknown")
    UNKNOWN("Unknown");

    override fun toString(): String = status
}
