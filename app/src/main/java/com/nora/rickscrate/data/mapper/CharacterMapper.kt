package com.nora.rickscrate.data.mapper

import com.nora.rickscrate.data.model.CharacterResponse
import com.nora.rickscrate.domain.model.Character
import com.nora.rickscrate.ui.utils.removePrefixOfListMember

fun CharacterResponse.toDomainModel(): Character {

    val preFix = "https://rickandmortyapi.com/api/episode/"

    return Character(
        id = id,
        name = name,
        status = statusResponse.value(),
        species = species,
        type = type,
        gender = genderResponse.value(),
        origin = originResponse.name,
        lastAppearance = lastAppearance.name,
        image = image,
        episode = removePrefixOfListMember(preFix, episode)
    )
}