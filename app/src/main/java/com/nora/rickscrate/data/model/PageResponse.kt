package com.nora.rickscrate.data.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class PageResponse<T>(
    @Json(name = "info")
    val pageInfo: Info,
    @Json(name = "results")
    val results: List<T> = listOf()
)

data class Info(
    @Json(name = "count")
    val count: Int,
    @Json(name = "pages")
    val pages: Int,
    @Json(name = "next")
    val next: String?,
    @Json(name = "prev")
    val prev: String?
)