package me.alexa.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.*
import androidx.compose.ui.awt.ComposeWindow
import java.awt.FileDialog

@Preview
@Composable
fun AppPreview() {
    App()
}

@Composable
actual fun openFileDialog() {
    var result by remember { mutableStateOf("") }
    val allowedExtensions = listOf(".jpg")

    LaunchedEffect(key1 = result) {
        result = FileDialog(ComposeWindow(), "rt", FileDialog.LOAD).apply {
            isMultipleMode = false

            // windows
            file = allowedExtensions.joinToString(";") { "*$it" } // e.g. '*.jpg'

            // linux
            setFilenameFilter { _, name -> allowedExtensions.any { name.endsWith(it) } }
            isVisible = true
        }.files.toSet().firstOrNull()?.name ?: ""
    }
}
