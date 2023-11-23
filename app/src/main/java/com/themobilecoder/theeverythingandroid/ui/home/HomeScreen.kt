package com.themobilecoder.theeverythingandroid.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.themobilecoder.core.FeatureMetadata
import com.themobilecoder.theeverything_android.R
import com.themobilecoder.theeverythingandroid.ui.config.TmcBlue
import com.themobilecoder.theeverythingandroid.ui.config.TmcWhite
import com.themobilecoder.theeverythingandroid.ui.config.Typography


@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        homeScreenViewModel.destinationState.collect { destinationRoute ->
            navController.navigate(destinationRoute)
        }
    }
    Scaffold { scaffoldPadding ->
        Column(
            modifier = Modifier
                .padding(scaffoldPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var text by remember { mutableStateOf("") }
            val destinations = homeScreenViewModel.uiState.collectAsState().value.destinations
            val filteredDestinations = destinations.filter(containedInFeatureMetadata(text))
            Spacer(modifier = Modifier.height(24.0.dp))
            Text(
                stringResource(id = R.string.app_name),
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(24.0.dp))
            OutlinedTextField(
                value = text,
                onValueChange = { newText ->
                    text = newText
                },
                trailingIcon = {
                    Icon(Icons.Filled.Search, "", tint = TmcBlue)
                },
                shape = RoundedCornerShape(24.dp),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = TmcWhite,
                ),
            )
            Spacer(modifier = Modifier.height(32.0.dp))
            LazyColumn(
                Modifier.fillMaxSize(),
            ) {
                items(filteredDestinations.size) { index ->
                    val featureData = filteredDestinations[index].featureData
                    Box(
                        Modifier
                            .fillMaxSize()
                            .clickable {
                                homeScreenViewModel.navigateToFeature(featureData.destination)
                            }
                    ) {
                        Column(
                            Modifier.padding(horizontal = 24.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(vertical = 8.dp),
                                text = featureData.title,
                                style = Typography.titleMedium
                            )
                            Text(
                                modifier = Modifier.padding(bottom = 4.dp),
                                text = featureData.description,
                                style = Typography.bodyMedium
                            )
                            Spacer(Modifier.height(12.dp))
                        }
                    }
                }
            }

        }
    }


}

@Composable
private fun containedInFeatureMetadata(text: String): (FeatureMetadata) -> Boolean =
    {
        val trimmedText = text.trim()
        it.featureData.title.contains(trimmedText, ignoreCase = true) ||
                it.featureData.description.contains(trimmedText, ignoreCase = true) ||
                trimmedText.isBlank()
    }