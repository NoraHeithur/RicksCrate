package com.nora.rickscrate.data.repository.episode

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nora.rickscrate.data.network.RnMEpisodeService
import com.nora.rickscrate.data.paging.EpisodePagingSource
import com.nora.rickscrate.domain.model.Episode
import com.nora.rickscrate.domain.repository.episode.EpisodeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(private val service: RnMEpisodeService) :
    EpisodeRepository {

    private val pageSize = 20

    override suspend fun getEpisodePagingData(): Flow<PagingData<Episode>> {
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = { EpisodePagingSource(service) }
        ).flow
    }
}