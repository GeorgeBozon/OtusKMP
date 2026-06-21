package com.example.otuskmp

interface KMPClipboardManager{
    fun copyToClipBoard(text: String)

    suspend fun getFromClipBoard(): String?
}