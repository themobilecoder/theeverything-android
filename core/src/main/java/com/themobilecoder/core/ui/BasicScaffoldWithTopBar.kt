@file:OptIn(ExperimentalMaterial3Api::class)

package com.themobilecoder.core.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BasicScaffoldWithTopBar(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (() -> Unit) = { },
    title: String = "",
    onBackButtonPressed: () -> Unit = {},
    isBackButtonEnabled: Boolean = true,
    content: @Composable (PaddingValues) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        snackbarHost = snackbarHost,
        topBar = topBar ?: {
            val scrollBehavior =
                TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            CenterAlignedTopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    if (isBackButtonEnabled) {
                        IconButton(
                            onClick = onBackButtonPressed
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Navigate up button"
                            )
                        }
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) {
        content(it)
    }
}
