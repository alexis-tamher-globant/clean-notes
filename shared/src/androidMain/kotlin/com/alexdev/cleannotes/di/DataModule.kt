package com.alexdev.cleannotes.di

import com.alexdev.cleannotes.data.driver.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun dataModule(): Module = module {
  single { DatabaseDriverFactory(get()) }
}