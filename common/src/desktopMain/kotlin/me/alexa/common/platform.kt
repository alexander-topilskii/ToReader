package me.alexa.common

import androidx.compose.runtime.*
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.runtime.MutableState
import java.awt.FileDialog
import java.io.File

actual fun getPlatformName(): String {
    return "Desktop"
}

@Composable
actual fun openFileDialog(allowedExtensions: List<String>, onResult: (File?) -> Unit) {
    LaunchedEffect(key1 = allowedExtensions) {
        val firstOrNull = FileDialog(ComposeWindow(), "Choose File", FileDialog.LOAD).apply {
            isMultipleMode = false

            // windows
            file = allowedExtensions.joinToString(";") { "*$it" }

            // linux
            setFilenameFilter { _, name -> allowedExtensions.any { name.endsWith(it) } }
            isVisible = true
        }.files.toSet().firstOrNull()
        onResult(firstOrNull)
    }
}