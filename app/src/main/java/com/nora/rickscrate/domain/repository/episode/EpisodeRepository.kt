package com.nora.rickscrate.domain.repository.episode

import androidx.paging.PagingData
import com.nora.rickscrate.domain.model.Episode
import kotlinx.coroutines.flow.Flow

interface EpisodeRepository {

    suspend fun getEpisodePagingData(): Flow<PagingData<Episode>>
}