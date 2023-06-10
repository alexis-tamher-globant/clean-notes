package com.alexdev.cleannotes.data.repository

import com.alexdev.cleannotes.domain.model.Note
import com.alexdev.cleannotes.domain.repository.NoteDataSource
import com.alexdev.cleannotes.util.DateTimeUtil
import com.alexdev.cleannotes.util.randomColor

typealias dataSource = NoteDataSourceImpl

object NoteDataSourceImpl : NoteDataSource {

  private val notes = (1..6).toList().map {
    Note(
      it.toLong(),
      "title $it",
      "this is the content $it",
      randomColor(),
      DateTimeUtil.now()
    )
  }.toMutableList()

  override suspend fun insertNote(note: Note) {
    if (note.id == -1L) {
      val id = (1..100).filter { it -> !notes.map { it.id }.contains(it.toLong()) }.random().toLong()
      val newNote = note.copy(id = id)
      notes.add(newNote)
    } else {
      notes.indexOfFirst { it.id == note.id }.run {
        notes.set(this, note)
      }
    }

  }

  override suspend fun getNoteById(id: Long): Note? {
    return notes.firstOrNull { note -> note.id == id }
  }

  override suspend fun getAllNotes(): List<Note> = notes.sortedBy { it.id }

  override suspend fun deleteNoteById(id: Long) {
    notes.firstOrNull { it.id == id }?.run {
      notes.remove(this)
    }
  }
}