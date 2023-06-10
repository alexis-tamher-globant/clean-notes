package com.alexdev.cleannotes.android.presentation.note.note_list

import com.alexdev.cleannotes.domain.model.Note

data class NoteListState(
  val notes: List<Note> = emptyList(),
  val query: String = "",
  val isSearching: Boolean = false
)