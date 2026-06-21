package com.example.otuskmp.di

import com.example.otuskmp.StopwatchViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

class KoinIosDependencies: KoinComponent {

    fun getViewModel(): StopwatchViewModel = get()
}
