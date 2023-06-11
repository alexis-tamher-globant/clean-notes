package com.alexdev.local_storage.driver

import com.alexdev.local_storage.database.NoteDataBase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
  actual fun createDriver(): SqlDriver {
    return NativeSqliteDriver(NoteDataBase.Schema, "note.db")
  }
}