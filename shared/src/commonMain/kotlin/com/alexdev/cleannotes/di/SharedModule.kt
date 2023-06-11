package com.alexdev.cleannotes.di

import com.alexdev.cleannotes.data.repository.NoteDataSourceImpl
import com.alexdev.cleannotes.domain.repository.NoteDataSource
import org.koin.core.module.Module
import org.koin.dsl.module

fun sharedModule(): Module = module {

  single<NoteDataSource> {
    NoteDataSourceImpl(get())
  }
}