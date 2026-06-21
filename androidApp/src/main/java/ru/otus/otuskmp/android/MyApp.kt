package ru.otus.otuskmp.android

import android.app.Application
import com.example.otuskmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MyApp)
            androidLogger()
        }
    }
}