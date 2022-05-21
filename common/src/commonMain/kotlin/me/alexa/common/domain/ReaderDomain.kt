package me.alexa.common.domain

import kotlinx.coroutines.flow.Flow
import me.alexa.common.data.Store
import java.io.InputStream

class ReaderDomain(private val store: Store = Store()) {

    fun observeText(): Flow<String> = store.content

    suspend fun readText(instream: InputStream?) {
        val result: String? = instream?.bufferedReader().use { it?.readText() }
        store.updateText(result)
    }
}