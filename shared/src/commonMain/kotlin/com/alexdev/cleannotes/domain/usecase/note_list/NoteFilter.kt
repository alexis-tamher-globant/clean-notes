package com.alexdev.cleannotes.domain.usecase.note_list

import com.alexdev.cleannotes.domain.model.Note

object NoteFilter {
  fun filter(notes: List<Note>, query: String): List<Note> {
    return notes.filter { note ->
      note.title.lowercase().contains(query.lowercase()) || note.content.lowercase()
        .contains(query.lowercase())
    }
  }
}