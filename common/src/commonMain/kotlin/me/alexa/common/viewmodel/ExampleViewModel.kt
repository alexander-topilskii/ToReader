package me.alexa.common.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import me.alexa.common.domain.State
import java.io.InputStream
import java.net.URI

class ExampleViewModel {
    val uiState = MutableStateFlow(
        State(
            text = "init text",
            content = "no content",
            isDialogVisible = false
        )
    )


    fun onButtonClicked() {
        uiState.update {
            it.copy(
                isDialogVisible = true
            )
        }
    }

    fun updateFile(uri: URI?, instream: InputStream?) {
        val result: String? = instream?.bufferedReader().use { it?.readText() }
        uiState.update {
            it.copy(
                text = uri.toString(),
                content = result.orEmpty(),
                isDialogVisible = false
            )
        }
    }
}