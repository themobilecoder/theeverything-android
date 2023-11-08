package com.themobilecoder.theeverythingandroid.ui.destination

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DestinationScreen(
    viewModel: DestinationScreenViewModel = viewModel<DestinationScreenViewModel>().apply {
        init()
    },
) {
    viewModel.destinationState.collectAsState().value.let {
        Surface {
            Box(Modifier.fillMaxSize()) {
                Text(
                    (it as DestinationScreenUiState.Init).text,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}