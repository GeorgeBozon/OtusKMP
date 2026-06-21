package com.example.otuskmp

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context

private const val LABEL = "CLIPBOARD_TEXT"

class AndroidClipboardManager(private val context: Context) : KMPClipboardManager {
    private val clipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    override fun copyToClipBoard(text: String) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText(LABEL, text))
    }

    override suspend fun getFromClipBoard(): String? {
        val description = clipboardManager.primaryClipDescription
        return if (description!=null && description.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)){
            clipboardManager.primaryClip?.getItemAt(0)?.text.toString()
        } else {
            null
        }
    }
}