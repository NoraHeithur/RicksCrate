package com.nora.rickscrate.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel: ViewModel() {

    fun launchWithViewModelScope(execute: suspend () -> Unit) {
        viewModelScope.launch {
            execute()
        }
    }
}