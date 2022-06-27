package com.nora.rickscrate.data.repository.character

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.nora.rickscrate.domain.model.Character
import com.nora.rickscrate.data.network.RnMCharacterService
import com.nora.rickscrate.data.paging.CharacterPagingSource
import com.nora.rickscrate.domain.repository.character.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: RnMCharacterService
) : CharacterRepository {

    private val initialPageSize = 20

    override suspend fun getCharacterPagingData(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(
                pageSize = initialPageSize,
                enablePlaceholders = false,
                prefetchDistance = 1
            ),
            pagingSourceFactory = { CharacterPagingSource(service) }
        ).flow
    }
}