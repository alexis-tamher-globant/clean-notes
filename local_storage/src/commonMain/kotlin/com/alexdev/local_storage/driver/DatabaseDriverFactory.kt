package com.alexdev.local_storage.driver

import com.alexdev.local_storage.database.NoteDataBase
import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {
  fun createDriver(): SqlDriver
}
