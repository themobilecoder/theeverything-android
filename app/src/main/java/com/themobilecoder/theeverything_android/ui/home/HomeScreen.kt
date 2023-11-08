package com.themobilecoder.theeverything_android.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.themobilecoder.theeverything_android.ui.config.Typography


@Composable
fun HomeScreen(
    navController: NavController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        homeScreenViewModel.destinationState.collect {
            when (it) {
                is HomeScreenDestinationState.Destination -> {
                    navController.navigate("destination/${it.args}")
                }

                is HomeScreenDestinationState.Home -> {
                    navController.navigate("home")
                }
            }
        }
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var text by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(24.0.dp))
        Text(
            "The Everything - Android",
            style = Typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.0.dp))
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            trailingIcon = {
                Icon(Icons.Filled.Search, "")
            },
            shape = RoundedCornerShape(24.dp),
            singleLine = true,
            keyboardActions = KeyboardActions(
                onDone = {
                    homeScreenViewModel.navigateToDestination(text)
                })
        )
    }

}