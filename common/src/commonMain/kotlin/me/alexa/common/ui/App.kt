package me.alexa.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.alexa.common.domain.State
import me.alexa.common.openFileDialog
import me.alexa.common.viewmodel.ExampleViewModel

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

    displayDialog(state, viewModel)
}

@Composable
private fun displayDialog(state: State, viewModel: ExampleViewModel) {
    if (state.isDialogVisible) {
        openFileDialog(allowedExtensions = listOf(".*"), onResult = { uri, instream ->
            viewModel.updateFile(uri, instream)
        })
    }
}

