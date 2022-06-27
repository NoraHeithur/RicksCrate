package com.nora.rickscrate.data.repository.location

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nora.rickscrate.data.network.RnMLocationService
import com.nora.rickscrate.data.paging.LocationPagingSource
import com.nora.rickscrate.domain.model.Location
import com.nora.rickscrate.domain.repository.location.LocationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val service: RnMLocationService) :
    LocationRepository {

    private val pageSize = 20

    override suspend fun getLocationPagingData(): Flow<PagingData<Location>> {
        return Pager(
            config = PagingConfig(
                pageSize = pageSize,
                enablePlaceholders = false,
                prefetchDistance = 2
            ),
            pagingSourceFactory = { LocationPagingSource(service) }
        ).flow
    }
}