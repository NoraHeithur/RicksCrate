package com.nora.rickscrate.ui.screen.character

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nora.rickscrate.domain.model.Character
import com.nora.rickscrate.domain.repository.character.CharacterRepository
import com.nora.rickscrate.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : BaseViewModel() {

    private lateinit var _characterFlow: Flow<PagingData<Character>>
    val characterFlow: Flow<PagingData<Character>>
        get() = _characterFlow

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() = launchWithViewModelScope {
        _characterFlow = repository.getCharacterPagingData().cachedIn(viewModelScope)
    }
}