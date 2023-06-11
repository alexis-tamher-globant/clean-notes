package com.alexdev.local_storage.di

import com.alexdev.local_storage.driver.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun dataModule(): Module = module {
  single { DatabaseDriverFactory() }
}