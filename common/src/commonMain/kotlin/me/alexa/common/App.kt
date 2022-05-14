package me.alexa.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.io.File
import java.io.InputStream

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var isDialogVisible by remember { mutableStateOf(false) }
    var file by remember { mutableStateOf<InputStream?>(null) }

    Column {
        Button(onClick = {
            text = "Hello, ${getPlatformName()}"
            isDialogVisible = true
        }) {
            Text(text)
        }

        Text(text = if (file != null) "file found" else "nothing to show", modifier = Modifier.padding(16.dp))
    }


    if (isDialogVisible) {
        openFileDialog(allowedExtensions = listOf(".*"), onResult = { uri, instream ->
            file = instream
            instream?.bufferedReader()?.forEachLine { println(it) }
        })
    }

}
