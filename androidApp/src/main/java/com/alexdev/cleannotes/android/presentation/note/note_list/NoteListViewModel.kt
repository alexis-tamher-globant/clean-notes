package com.alexdev.cleannotes.android.presentation.note.note_list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexdev.cleannotes.domain.model.Note
import com.alexdev.cleannotes.domain.repository.NoteDataSource
import com.alexdev.cleannotes.domain.usecase.note_list.NoteFilter
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch


class NoteListViewModel(
  private val savedStateHandle: SavedStateHandle,
  private val dataSource: NoteDataSource
) : ViewModel() {
  private val notes = savedStateHandle.getStateFlow("notes", emptyList<Note>())
  private val query = savedStateHandle.getStateFlow("query", "")
  private val isSearching = savedStateHandle.getStateFlow("isSearching", false)

  val state = combine(notes, query, isSearching) { notes, query, isSearching ->
    NoteListState(NoteFilter.filter(notes, query), query, isSearching)
  }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteListState())

  fun loadNotes() {
    viewModelScope.launch {
      savedStateHandle["notes"] = dataSource.getAllNotes()
    }
  }

  fun toggleIsSearching() {
    savedStateHandle["isSearching"] = !isSearching.value
  }

  fun onSearch(query: String) {
    savedStateHandle["query"] = query
  }

  fun deleteNote(id: Long) {
    viewModelScope.launch {
      dataSource.deleteNoteById(id)
      loadNotes()
    }
  }

}