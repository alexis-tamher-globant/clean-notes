package com.alexdev.cleannotes.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alexdev.cleannotes.android.presentation.note.note_detail.NoteDetailScreen
import com.alexdev.cleannotes.android.presentation.note.note_list.NoteListScreen

@Composable
fun MainNavigation() {
  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = Screen.NoteList.route) {
    composable(
      route = Screen.NoteList.route
    ) { _ ->
      NoteListScreen(onNoteTapped = { noteId ->
        navController.navigate(Screen.NoteDetail.route + "/$noteId")
      })
    }
    composable(
      route = Screen.NoteDetail.route + "/{noteId}",
      arguments = listOf(
        navArgument("noteId") {
          type = NavType.LongType
        }
      )
    ) { navBackStackEntry ->
      val id = navBackStackEntry.arguments?.getLong("noteId")?.let { if(it == -1L) null else it }
      NoteDetailScreen(noteId = id, onSavedNote = { navController.popBackStack() })
    }
  }
}