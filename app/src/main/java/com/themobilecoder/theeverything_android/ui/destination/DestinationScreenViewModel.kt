package com.themobilecoder.theeverything_android.ui.destination

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DestinationScreenViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val _destinationState = MutableStateFlow<DestinationScreenUiState>(
        DestinationScreenUiState.Init("")
    )
    val destinationState: StateFlow<DestinationScreenUiState> = _destinationState

    fun init() {
        val args = savedStateHandle.get<String>("args") ?: "EMPTY"
        viewModelScope.launch {
            _destinationState.emit(DestinationScreenUiState.Init(args))
        }
    }
}