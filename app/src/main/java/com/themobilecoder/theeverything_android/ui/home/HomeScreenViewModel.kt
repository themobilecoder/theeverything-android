package com.themobilecoder.theeverything_android.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
) : ViewModel() {

    private val _destinationState = MutableSharedFlow<HomeScreenDestinationState>(
        extraBufferCapacity = 1
    )
    val destinationState: SharedFlow<HomeScreenDestinationState> = _destinationState
    fun navigateToDestination(arg: String) {
        viewModelScope.launch {
            _destinationState.tryEmit(HomeScreenDestinationState.Destination(arg))
        }
    }
}