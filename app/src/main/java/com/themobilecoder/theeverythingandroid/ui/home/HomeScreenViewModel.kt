package com.themobilecoder.theeverythingandroid.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor() : ViewModel() {

    private val _destinationState = MutableSharedFlow<HomeScreenDestinationState>(
        extraBufferCapacity = 1
    )
    val destinationState: SharedFlow<HomeScreenDestinationState> = _destinationState
    fun navigateToSnackbarDemo() {
        _destinationState.tryEmit(HomeScreenDestinationState.SnackbarDemo)
    }
}