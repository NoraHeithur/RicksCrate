package com.nora.rickscrate.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.nora.rickscrate.data.mapper.toDomainModel
import com.nora.rickscrate.data.network.RnMCharacterService
import com.nora.rickscrate.data.util.nextPage
import com.nora.rickscrate.domain.model.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterPagingSource(private val service: RnMCharacterService) :
    PagingSource<Int, Character>() {

    private val initialPoint = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val initialPage = params.key ?: initialPoint

        return try {
            val characterResponse = withContext(Dispatchers.IO) {
                service.fetchCharactersResponse(initialPage)
            }
            val pageResponse = characterResponse.body()
            val fetchResult = pageResponse?.results

            val characterData = fetchResult?.let { response ->
                response.map { data ->
                    data.toDomainModel()
                }
            }

            val nextKey = nextPage(pageResponse?.pageInfo?.next)

            LoadResult.Page(
                data = characterData.orEmpty(),
                prevKey = null,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int = initialPoint
}