package com.themobilecoder.core.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ListItemWithDescription(
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    Box(
        Modifier
            .fillMaxSize()
            .clickable {
                onClick()
            }
    ) {
        Column(
            Modifier.padding(horizontal = 24.dp)
        ) {
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = title,
                style = typography.titleSmall,
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = description,
                style = typography.bodyMedium,
            )
            HorizontalDivider(
                modifier = Modifier.padding(top = 8.dp),
                thickness = 1.dp,
                color = androidx.compose.material3.MaterialTheme.colorScheme.outline.copy(
                    alpha = 0.1f
                )
            )
        }
    }
}