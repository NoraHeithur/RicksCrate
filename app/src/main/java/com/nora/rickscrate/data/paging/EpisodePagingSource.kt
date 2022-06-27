package com.nora.rickscrate.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nora.rickscrate.data.mapper.toDomainModel
import com.nora.rickscrate.data.network.RnMEpisodeService
import com.nora.rickscrate.data.util.nextPage
import com.nora.rickscrate.domain.model.Episode
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EpisodePagingSource(private val service: RnMEpisodeService) :
    PagingSource<Int, Episode>() {

    private val initialPage = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Episode> {
        val startPage = params.key ?: initialPage

        return try {
            val episodeResponse = withContext(Dispatchers.IO) {
                service.fetchEpisodesResponse(startPage)
            }
            val pageResponse = episodeResponse.body()
            val result = pageResponse?.results

            val episodes = result?.let { response ->
                response.map { data ->
                    data.toDomainModel()
                }
            }

            val nextPage = nextPage(pageResponse?.pageInfo?.next)

            LoadResult.Page(
                data = episodes.orEmpty(),
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Episode>): Int = initialPage
}