package com.alexdev.cleannotes.data.repository

import com.alexdev.cleannotes.data.driver.DatabaseDriverFactory
import com.alexdev.cleannotes.database.NoteDataBase
import com.alexdev.cleannotes.domain.model.Note
import com.alexdev.cleannotes.domain.repository.NoteDataSource
import com.alexdev.cleannotes.util.DateTimeUtil
import com.alexdev.cleannotes.util.toModel

class NoteDataSourceImpl(
  driver: DatabaseDriverFactory,
) : NoteDataSource {
  private val db = NoteDataBase.invoke(driver.createDriver())
  private val queries = db.noteQueries

  override suspend fun insertNote(note: Note) {
    queries.insertNote(
      note.title,
      note.content,
      note.color,
      DateTimeUtil.toEpochMillis(note.date)
    )
  }

  override suspend fun updateNote(note: Note) {
    queries.updateNote(
      note.id,
      note.title,
      note.content,
      note.color,
      DateTimeUtil.toEpochMillis(note.date)
    )
  }

  override suspend fun getNoteById(id: Long): Note? {
    return queries.getNoteById(id).executeAsOneOrNull()?.toModel()
  }

  override suspend fun getAllNotes(): List<Note> {
    return queries.getAllNotes().executeAsList().map { note -> note.toModel() }
  }

  override suspend fun deleteNoteById(id: Long) {
    queries.deleteNoteById(id)
  }
}