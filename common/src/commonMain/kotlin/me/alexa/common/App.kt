package me.alexa.common

import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var isDialogVisible by remember { mutableStateOf(false) }

    Button(onClick = {
        text = "Hello, ${getPlatformName()}"
        isDialogVisible = true
    }) {
        Text(text)
    }

    if (isDialogVisible) {
        openFileDialog()
    }
}

@Composable
expect fun openFileDialog()
