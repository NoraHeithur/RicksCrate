package com.nora.rickscrate.ui.screen.location

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.nora.rickscrate.domain.model.Location
import com.nora.rickscrate.domain.repository.location.LocationRepository
import com.nora.rickscrate.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val repository: LocationRepository
) : BaseViewModel() {

    private lateinit var _locationFlow: Flow<PagingData<Location>>
    val locationFlow: Flow<PagingData<Location>>
        get() = _locationFlow

    init {
        fetchLocations()
    }

    private fun fetchLocations() = launchWithViewModelScope {
        _locationFlow = repository.getLocationPagingData().cachedIn(viewModelScope)
    }
}