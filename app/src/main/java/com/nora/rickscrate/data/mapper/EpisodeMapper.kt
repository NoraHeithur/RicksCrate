package com.nora.rickscrate.data.mapper

import com.nora.rickscrate.data.model.EpisodeResponse
import com.nora.rickscrate.domain.model.Episode
import com.nora.rickscrate.ui.utils.removePrefixOfListMember

fun EpisodeResponse.toDomainModel(): Episode {

    val prefix = "https://rickandmortyapi.com/api/character/"

    return Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = removePrefixOfListMember(prefix, characters)
    )
}