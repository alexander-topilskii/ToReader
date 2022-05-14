package me.alexa.common

import java.io.InputStream
import java.net.URI

expect fun getPlatformName(): String

expect fun openFileDialog(allowedExtensions: List<String>, onResult: (URI?, InputStream?) -> Unit)
