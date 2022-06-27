package com.nora.rickscrate.domain.model

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val character: List<String>?
)
