package me.alexa.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import java.io.InputStream
import java.net.URI
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.asStateFlow

@Composable
fun App() {
    val viewModel = remember { ExampleViewModel() }
    val state = viewModel.uiState.collectAsState().value

    Column {
        Button(onClick = {
            viewModel.onButtonClicked()
        }) {
            Text("open file")
        }

        Text(
            text = state.text,
            modifier = Modifier.background(Color(0xFF86a2e3)).padding(16.dp)
        )

        Text(
            text = state.content,
            modifier = Modifier.background(Color.Gray).padding(16.dp)
        )
    }


    if (state.isDialogVisible) {
        openFileDialog(allowedExtensions = listOf(".*"), onResult = { uri, instream ->
            viewModel.updateFile(uri, instream)
        })
    }
}

class ExampleViewModel {

    val uiState = MutableStateFlow(State(text = "init text", content = "no content", isDialogVisible = false))


    fun onButtonClicked() {
        uiState.update { it.copy(text = "new Text", isDialogVisible = true) }
    }

    fun updateFile(uri: URI?, instream: InputStream?) {
        val result: String? = instream?.bufferedReader().use { it?.readText() }
        uiState.update {
            it.copy(
                text = uri.toString(),
                content = result.orEmpty()
            )
        }
    }
}

data class State(
    val text: String,
    val content: String,
    val isDialogVisible: Boolean,
)
