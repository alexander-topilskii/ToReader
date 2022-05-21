package me.alexa.common.domain

import Reader
import kotlinx.coroutines.flow.Flow
import me.alexa.common.data.Store
import java.io.InputStream

class ReaderDomain(private val store: Store = Store()) {
    val reader = Reader()

    fun observeText(): Flow<String> = store.content

    suspend fun readText(instream: InputStream?) {
        val result: String? = instream?.bufferedReader().use { it?.readText() }
        val parsed = reader.parse(result)
        store.updateText(result)
    }
}