package com.alexdev.cleannotes.android.presentation.note.note_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.koin.androidx.compose.getViewModel

@Composable
fun NoteDetailScreen(
  noteId: Long?,
  onSavedNote: () -> Unit,
  viewModel: NoteDetailViewModel = getViewModel(),
) {
  val state by viewModel.state.collectAsState()

  LaunchedEffect(key1 = null) {
    noteId?.run {
      viewModel.loadNote(noteId)
    }
  }

  Scaffold(
    floatingActionButton = {
      FloatingActionButton(
        onClick = {
          viewModel.saveNote()
          onSavedNote()
        },
        backgroundColor = Color.Black,
      ) {
        Icon(
          imageVector = Icons.Default.Check,
          contentDescription = "save note",
          tint = Color.White
        )
      }
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
        .background(Color(state.color))
    ) {
      TextField(
        value = state.title,
        label = { Text(text = "Title") },
        onValueChange = { viewModel.updateTitle(it) },
        modifier = Modifier.fillMaxWidth()
      )
      TextField(
        value = state.content,
        label = { Text(text = "Content") },
        modifier = Modifier.fillMaxWidth().weight(1f),
        onValueChange = { viewModel.updateContent(it) },
        placeholder = null
      )
    }
  }
}

@Preview
@Composable
fun PreviewNoteDetailScreen() {
  NoteDetailScreen(null, onSavedNote = {})
}