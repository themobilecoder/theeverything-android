@file:OptIn(ExperimentalMaterial3Api::class)

package com.themobilecoder.snackbar_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SnackbarDemoScreen(
    onBackButtonPressed: () -> Unit,
    viewModel: SnackbarDemoScreenViewModel = hiltViewModel(),
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier,
                title = {
                    Text(
                        "Snackbar Demo",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackButtonPressed
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Navigate up button"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
        snackbarHost = {
            SnackbarHost(
                hostState = snackbarHostState,
                snackbar = { snackbarData ->
                    Snackbar(
                        snackbarData = snackbarData,
                        containerColor = MaterialTheme.colorScheme.primary,
                        actionColor = MaterialTheme.colorScheme.onPrimary
                    )
                }
            )
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SimpleActionCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                title = "Standard snackbar",
                description = "Displays a common snackbar",
                actionButtonText = "Show",
                onActionButtonClicked = {
                    viewModel.onShowStandardSnackbar()
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            SimpleActionCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                title = "Snackbar with action",
                description = "Displays a common snackbar with an action",
                actionButtonText = "Show",
                onActionButtonClicked = {
                    viewModel.onShowSnackbarWithButton()
                }
            )
        }
    }
    LaunchedEffect(Unit) {
        viewModel.snackbarSharedFlow.collect { type ->
            snackbarHostState.currentSnackbarData?.dismiss()

            when (type) {
                SnackbarType.STANDARD_SNACKBAR -> {
                    snackbarHostState.showSnackbar(
                        message = "Standard snackbar",
                        duration = SnackbarDuration.Short
                    )
                }

                SnackbarType.SNACKBAR_WITH_BUTTON -> {
                    val result = snackbarHostState.showSnackbar(
                        message = "Snackbar with Button",
                        duration = SnackbarDuration.Short,
                        actionLabel = "Dismiss"
                    )
                    when (result) {
                        SnackbarResult.ActionPerformed -> {
                            snackbarHostState.currentSnackbarData?.dismiss()
                        }

                        else -> {}
                    }
                }
            }

        }
    }
}

enum class SnackbarType {
    STANDARD_SNACKBAR,
    SNACKBAR_WITH_BUTTON,
}