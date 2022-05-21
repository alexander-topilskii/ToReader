package me.alexa.common.domain

data class State(
    val text: String,
    val content: String,
    val isDialogVisible: Boolean,
)