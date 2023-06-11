package com.alexdev.local_storage.driver

import android.content.Context
import com.alexdev.local_storage.database.NoteDataBase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context? = null) {
  actual fun createDriver(): SqlDriver {
    return AndroidSqliteDriver(NoteDataBase.Schema, context!!, "note.db")
  }
}