package com.themobilecoder.images_demo.internal.ui.screens.imagepicker

import android.net.Uri
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageOnly
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.themobilecoder.core.ui.BasicScaffoldWithTopBar

@Composable
internal fun ImagePickerScreen(
    navController: NavController,
) {
    var uri by remember { mutableStateOf<Uri?>(null) }
    val pickMedia: ManagedActivityResultLauncher<PickVisualMediaRequest, Uri?> =
        rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uriResult ->
            if (uriResult != null) {
                uri = uriResult
            } else {
                Log.d("PhotoPicker", "No media selected")
            }
        }
    BasicScaffoldWithTopBar(
        title = "Image Picker",
        onBackButtonPressed = { navController.navigateUp() }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            TextButton(
                modifier = Modifier
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = colorScheme.tertiary,
                    contentColor = colorScheme.onTertiary,
                ),
                onClick = {
                    pickMedia.launch(PickVisualMediaRequest(ImageOnly))

                }
            ) {
                Text("Pick an image", textAlign = TextAlign.Center)
            }
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                model = uri,
                contentDescription = "Selected Image",
            )
        }
    }
}