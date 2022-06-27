package com.nora.rickscrate.domain.repository.location

import androidx.paging.PagingData
import com.nora.rickscrate.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    suspend fun getLocationPagingData(): Flow<PagingData<Location>>
}