package me.alexa.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import java.io.File

expect fun getPlatformName(): String

expect fun openFileDialog(allowedExtensions: List<String>, onResult: (File?) -> Unit)
