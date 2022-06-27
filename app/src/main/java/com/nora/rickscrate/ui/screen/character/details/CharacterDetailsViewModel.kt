package com.nora.rickscrate.ui.screen.character.details

import com.nora.rickscrate.domain.model.EpisodeBound
import com.nora.rickscrate.domain.repository.character.CharacterDetailsRepository
import com.nora.rickscrate.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: CharacterDetailsRepository
) : BaseViewModel() {

    private val delayTime = 100L

    private lateinit var _relatedEpisode: Flow<List<EpisodeBound>>
    val relatedEpisode: Flow<List<EpisodeBound>>
        get() = _relatedEpisode

    fun setRelatedEpisode(episodes: List<String>) {
        launchWithViewModelScope {
            _relatedEpisode = flow {
                emit(repository.getRelatedEpisode(episodes))
                delay(delayTime)
            }
        }
    }
}