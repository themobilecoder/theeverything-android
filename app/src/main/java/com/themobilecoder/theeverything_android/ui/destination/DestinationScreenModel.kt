package com.themobilecoder.theeverything_android.ui.destination

sealed class DestinationScreenUiState {
    class Init(val text: String) : DestinationScreenUiState()
}