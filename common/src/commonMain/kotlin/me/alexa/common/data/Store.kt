package me.alexa.common.data

import kotlinx.coroutines.flow.MutableStateFlow

class Store {
    val content: MutableStateFlow<String> = MutableStateFlow("emptyText")

    suspend fun updateText(result: String?) {
        content.emit(result.orEmpty())
    }
}