package me.alexa.common

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import java.io.InputStream
import java.net.URI

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun openFileDialog(allowedExtensions: List<String>, onResult: (URI?, InputStream?) -> Unit) {
    val context = LocalContext.current

    val pickPictureLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { imageUri ->

        if (imageUri != null) {
            val item = context.contentResolver.openInputStream(imageUri)
            onResult(URI(imageUri.toString()), item)
        }
    }
    LaunchedEffect(key1 = pickPictureLauncher) {
        pickPictureLauncher.launch("*/*")
    }
}