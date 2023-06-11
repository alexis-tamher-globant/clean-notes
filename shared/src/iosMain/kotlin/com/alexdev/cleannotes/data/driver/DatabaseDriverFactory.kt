package com.alexdev.cleannotes.data.driver

import com.alexdev.cleannotes.database.NoteDataBase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
  actual fun createDriver(): SqlDriver {
    return NativeSqliteDriver(NoteDataBase.Schema, "note.db")
  }
}