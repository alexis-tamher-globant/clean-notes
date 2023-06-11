package com.alexdev.cleannotes.util

import com.alexdev.cleannotes.domain.model.Note
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toModel() = Note(
  id = id,
  title = title,
  content = content,
  color = colorHex,
  date = Instant
    .fromEpochMilliseconds(created)
    .toLocalDateTime(TimeZone.currentSystemDefault())
)