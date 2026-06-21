package com.example.otuskmp.di

import com.example.otuskmp.IOSClipboardManager
import com.example.otuskmp.KMPClipboardManager
import org.koin.dsl.module

actual val platformModule = module {
    single<KMPClipboardManager> { IOSClipboardManager() }
}