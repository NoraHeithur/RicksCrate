package com.nora.rickscrate.domain.repository.character

import androidx.paging.PagingData
import com.nora.rickscrate.domain.model.Character
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    suspend fun getCharacterPagingData(): Flow<PagingData<Character>>
}