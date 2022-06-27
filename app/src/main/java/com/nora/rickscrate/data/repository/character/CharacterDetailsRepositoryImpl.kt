package com.nora.rickscrate.data.repository.character

import com.nora.rickscrate.data.mapper.toDomainModel
import com.nora.rickscrate.data.network.RnMEpisodeService
import com.nora.rickscrate.domain.model.EpisodeBound
import com.nora.rickscrate.domain.repository.character.CharacterDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CharacterDetailsRepositoryImpl @Inject constructor(private val service: RnMEpisodeService) :
    CharacterDetailsRepository {

    override suspend fun getRelatedEpisode(episodes: List<String>): List<EpisodeBound> {
        return withContext(Dispatchers.IO) {
            val episodesResponse = service.fetchMultipleEpisodesResponse(episodes)
            val episodesBound = episodesResponse.body()
            episodesBound?.map { data -> data.toDomainModel() } ?: emptyList()
        }
    }
}