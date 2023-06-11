package com.alexdev.cleannotes.android.di

import androidx.lifecycle.SavedStateHandle
import com.alexdev.cleannotes.android.presentation.note.note_detail.NoteDetailViewModel
import com.alexdev.cleannotes.android.presentation.note.note_list.NoteListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val androidModule = module {
  viewModel {
    NoteListViewModel(get(), get())
  }

  viewModel {
    NoteDetailViewModel(get(), get())
  }

  single {
    SavedStateHandle()
  }
}