package com.example.otuskmp

import kotlinx.browser.window
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.await

class JSClipboardManager : KMPClipboardManager {
    override fun copyToClipBoard(text: String) {
        window.navigator.clipboard.writeText(text)
    }

    override suspend fun getFromClipBoard(): String? {
        return try {
            window.navigator.clipboard.readText().await()
        } catch (e: CancellationException) {
            null
        }
    }
}