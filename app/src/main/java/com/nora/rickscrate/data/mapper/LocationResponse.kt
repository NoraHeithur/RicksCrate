package com.nora.rickscrate.data.mapper

import com.nora.rickscrate.data.model.LocationResponse
import com.nora.rickscrate.domain.model.Location
import com.nora.rickscrate.ui.utils.removePrefixOfListMember


fun LocationResponse.toDomainModel(): Location {

    val prefix = "https://rickandmortyapi.com/api/character/"

    return Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        character = removePrefixOfListMember(prefix, residents)
    )
}