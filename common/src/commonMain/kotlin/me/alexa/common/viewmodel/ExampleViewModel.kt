package me.alexa.common.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import me.alexa.common.domain.ReaderDomain
import me.alexa.common.domain.State
import java.io.InputStream
import java.net.URI

class ExampleViewModel(
    private val domain: ReaderDomain = ReaderDomain()
) : CoroutineScope by CoroutineScopeImpl() {

    init {
        launch {
            domain.observeText().collect { content ->
                uiState.update { it.copy(content = content) }
            }
        }
    }

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
        launch {
            domain.readText(instream)
        }

        uiState.update {
            it.copy(
                text = uri.toString(),
                isDialogVisible = false
            )
        }
    }
}

