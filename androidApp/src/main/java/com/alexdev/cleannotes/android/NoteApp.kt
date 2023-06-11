package com.alexdev.cleannotes.android

import android.app.Application
import com.alexdev.cleannotes.android.di.androidModule
import com.alexdev.cleannotes.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class NoteApp: Application() {
  override fun onCreate() {
    super.onCreate()

    initKoin {
      androidContext(this@NoteApp)
      androidLogger()
      modules(androidModule)
    }
  }
}