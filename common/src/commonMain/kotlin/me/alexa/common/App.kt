package me.alexa.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.File

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var isDialogVisible by remember { mutableStateOf(false) }
    var fileName by remember { mutableStateOf<File?>(null) }

    Column {
        Button(onClick = {
            text = "Hello, ${getPlatformName()}"
            isDialogVisible = true
        }) {
            Text(text)
        }

        Text(text = fileName?.name ?: "nothing to show", modifier = Modifier.padding(16.dp))
    }


    if (isDialogVisible) {
        openFileDialog(allowedExtensions = listOf(".*"), onResult = {
            fileName = it
        })
    }

}
