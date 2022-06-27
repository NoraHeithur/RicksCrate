package com.nora.rickscrate.data.mapper

import com.nora.rickscrate.data.model.EpisodeBoundResponse
import com.nora.rickscrate.domain.model.EpisodeBound

fun EpisodeBoundResponse.toDomainModel(): EpisodeBound {
    return EpisodeBound(
        id = id,
        code = code
    )
}