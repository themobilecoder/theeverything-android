package com.themobilecoder.theeverythingandroid.ui.destination

sealed class DestinationScreenUiState {
    class Init(val text: String) : DestinationScreenUiState()
}