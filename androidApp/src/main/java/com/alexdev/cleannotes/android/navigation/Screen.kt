package com.alexdev.cleannotes.android.navigation

sealed class Screen(
  var route: String
) {
  object NoteList: Screen("note_list")
  object NoteDetail: Screen("note_detail")
}