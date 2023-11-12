package com.themobilecoder.snackbar_demo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SnackbarDemoScreen() {
    Scaffold {
        Box(
            Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Text(
                "Snackbar Screen",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}