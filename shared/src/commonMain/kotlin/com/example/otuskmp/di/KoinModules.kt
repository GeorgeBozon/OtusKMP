package com.example.otuskmp.di

import com.example.otuskmp.StopwatchViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module

val sharedModule = module {
    factory {StopwatchViewModel(get())}
}

expect val platformModule: Module

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication = startKoin {
    includes(config)
    modules(platformModule, sharedModule)
}