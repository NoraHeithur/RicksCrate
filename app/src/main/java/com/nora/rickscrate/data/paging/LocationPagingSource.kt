package com.nora.rickscrate.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nora.rickscrate.data.mapper.toDomainModel
import com.nora.rickscrate.data.network.RnMLocationService
import com.nora.rickscrate.data.util.nextPage
import com.nora.rickscrate.domain.model.Location
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocationPagingSource(private val service: RnMLocationService) :
    PagingSource<Int, Location>() {

    private val initialPage = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Location> {
        val startPage = params.key ?: initialPage

        return try {
            val locationResponse = withContext(Dispatchers.IO) {
                service.fetchLocationsResponse(startPage)
            }
            val pageResponse = locationResponse.body()
            val result = pageResponse?.results

            val locations = result?.let { response ->
                response.map { data ->
                    data.toDomainModel()
                }
            }

            val nextPage = nextPage(pageResponse?.pageInfo?.next)

            LoadResult.Page(
                data = locations.orEmpty(),
                prevKey = null,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Location>): Int = initialPage
}