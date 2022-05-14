package me.alexa.common

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.*
import java.io.File

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun openFileDialog(allowedExtensions: List<String>, onResult: (File?)->Unit) {
    val pickPictureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { imageUri ->
        if (imageUri != null) {
            println("GGGG: :openFileDialog $imageUri")
            onResult(File(imageUri.path!!))
        }
    }

    LaunchedEffect(key1 = pickPictureLauncher) {
        pickPictureLauncher.launch("*/*")
    }
}