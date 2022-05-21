package me.alexa.common

import androidx.compose.runtime.*
import androidx.compose.ui.awt.ComposeWindow
import java.awt.FileDialog
import java.io.InputStream
import java.net.URI

actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
actual fun openFileDialog(allowedExtensions: List<String>, onResult: (URI?, InputStream?) -> Unit) {
    LaunchedEffect(key1 = allowedExtensions) {
        val firstOrNull = FileDialog(ComposeWindow(), "Choose File", FileDialog.LOAD).apply {
            isMultipleMode = false

            // windows
            file = allowedExtensions.joinToString(";") { "*$it" }

            // linux
            setFilenameFilter { _, name -> allowedExtensions.any { name.endsWith(it) } }
            isVisible = true
        }.files.toSet().firstOrNull()

        onResult(firstOrNull?.toURI(), firstOrNull?.inputStream())
    }
}