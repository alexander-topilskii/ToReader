package me.alexa.common

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun openFileDialog() {
    var result by remember { mutableStateOf(false) }
    val pickPictureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { imageUri ->
        if (imageUri != null) {
            println("GGGG: :openChooser result: $imageUri")
            result = true
        }
    }
    LaunchedEffect(key1 = result) {
        pickPictureLauncher.launch("image/*")
    }
}