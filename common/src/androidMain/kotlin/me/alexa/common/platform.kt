package me.alexa.common

actual fun getPlatformName(): String {
    return "Android"
}


actual fun openFileDialog() {
    println("ahahah android")
}