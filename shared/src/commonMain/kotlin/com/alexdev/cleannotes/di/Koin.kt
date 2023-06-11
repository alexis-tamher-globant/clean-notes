package com.alexdev.cleannotes.di

import com.alexdev.cleannotes.domain.repository.NoteDataSource
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
  startKoin {
    appDeclaration()
    modules(
      dataModule(),
      sharedModule()
    )
  }

fun initKoin() = initKoin {}

class KoinHelper : KoinComponent {
  val dataSource by inject<NoteDataSource>()
}