package com.themobilecoder.snackbar_demo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleActionCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    actionButtonText: String,
    onActionButtonClicked: () -> Unit,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
        ) {
            Text(
                title,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(Modifier.height(8.dp))
            Text(description)
            Spacer(Modifier.height(24.dp))
            FilledTonalButton(
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary
                ),
                onClick = onActionButtonClicked
            ) {
                Text(actionButtonText)
            }
        }
    }
}

@Preview
@Composable
private fun SimpleActionCardPreview() {
    SimpleActionCard(
        title = "Test",
        description = "Description",
        actionButtonText = "Action",
        onActionButtonClicked = {}
    )
}