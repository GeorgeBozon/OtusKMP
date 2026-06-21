package com.example.otuskmp

import platform.UIKit.UIPasteboard

class IOSClipboardManager: KMPClipboardManager{
    override fun copyToClipBoard(text: String) {
        UIPasteboard.generalPasteboard.string = text
    }

    override suspend fun getFromClipBoard(): String? =
        UIPasteboard.generalPasteboard.string
}