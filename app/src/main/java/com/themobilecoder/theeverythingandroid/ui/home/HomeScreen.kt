package com.themobilecoder.theeverythingandroid.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar
import com.themobilecoder.core.ui.list.ListItemWithDescription
import com.themobilecoder.theeverything_android.R
import com.themobilecoder.theeverythingandroid.data.Feature


@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    var text by remember { mutableStateOf("") }
    val features = homeScreenViewModel.uiState.collectAsStateWithLifecycle().value.destinations
    val filteredDestinations = features.filter(containedInFeatureMetadata(text))
    LaunchedEffect(Unit) {
        homeScreenViewModel.destinationState.collect { destinationRoute ->
            navController.navigate(destinationRoute)
        }
    }
    BasicScaffoldWithTopBar(
        title = stringResource(id = R.string.app_name),
        isBackButtonEnabled = false
    ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .padding(scaffoldPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.0.dp))
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.0.dp),
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                trailingIcon = {
                    Icon(Icons.Filled.Search, "")
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.find_a_topic)
                    )
                },
                shape = RoundedCornerShape(12.dp),
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(24.0.dp))
            LazyColumn(
                Modifier.fillMaxSize(),
            ) {
                items(filteredDestinations.size) { index ->
                    val featureData = filteredDestinations[index]
                    ListItemWithDescription(
                        title = featureData.title,
                        description = featureData.description,
                        onClick = {
                            homeScreenViewModel.navigateToFeature(featureData.destination)
                        }
                    )
                }
            }

        }
    }


}

@Composable
private fun containedInFeatureMetadata(text: String): (Feature) -> Boolean =
    {
        val trimmedText = text.trim()
        it.title.contains(trimmedText, ignoreCase = true) ||
                it.description.contains(trimmedText, ignoreCase = true) ||
                it.tags.any { tag -> tag.contains(trimmedText, ignoreCase = true) } ||
                trimmedText.isBlank()
    }