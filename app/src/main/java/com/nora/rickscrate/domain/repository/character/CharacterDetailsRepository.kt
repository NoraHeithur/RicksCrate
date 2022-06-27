package com.nora.rickscrate.domain.repository.character

import com.nora.rickscrate.domain.model.EpisodeBound

interface CharacterDetailsRepository {

    suspend fun getRelatedEpisode(episodes: List<String>): List<EpisodeBound>
}