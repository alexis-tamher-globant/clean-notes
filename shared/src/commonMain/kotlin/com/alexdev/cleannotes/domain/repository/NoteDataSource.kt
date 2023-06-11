package com.alexdev.cleannotes.domain.repository

import com.alexdev.cleannotes.domain.model.Note

interface NoteDataSource {
  suspend fun insertNote(note: Note)
  suspend fun updateNote(note: Note)
  suspend fun getNoteById(id: Long): Note?
  suspend fun getAllNotes(): List<Note>
  suspend fun deleteNoteById(id: Long)
}