package com.themobilecoder.theeverythingandroid.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.themobilecoder.theeverythingandroid.data.Feature
import com.themobilecoder.theeverythingandroid.data.FeaturesRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    featuresRepo: FeaturesRepo,
) : ViewModel() {

    private val _destinationState = MutableSharedFlow<String>(
        extraBufferCapacity = 1
    )
    val destinationState: SharedFlow<String> = _destinationState

    private val _uiState = featuresRepo
        .featuresFlow
        .map { HomeScreenUiState(it) }
        .stateIn(
            started = SharingStarted.Lazily,
            initialValue = HomeScreenUiState(emptyList()),
            scope = viewModelScope
        )


    val uiState: StateFlow<HomeScreenUiState> = _uiState

    fun navigateToFeature(destinationRoute: String) {
        _destinationState.tryEmit(destinationRoute)
    }

    data class HomeScreenUiState(
        val destinations: List<Feature>,
    )
}