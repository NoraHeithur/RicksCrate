package com.nora.rickscrate.ui.screen.episode

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nora.rickscrate.domain.model.Episode
import com.nora.rickscrate.domain.repository.episode.EpisodeRepository
import com.nora.rickscrate.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val repository: EpisodeRepository
) : BaseViewModel() {

    private lateinit var _episodeFlow: Flow<PagingData<Episode>>
    val episodeFlow: Flow<PagingData<Episode>>
        get() = _episodeFlow

    init {
        fetchEpisodes()
    }

    private fun fetchEpisodes() = launchWithViewModelScope {
        _episodeFlow = repository.getEpisodePagingData().cachedIn(viewModelScope)
    }
}