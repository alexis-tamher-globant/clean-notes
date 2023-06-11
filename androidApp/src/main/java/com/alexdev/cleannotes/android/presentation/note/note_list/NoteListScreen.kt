package com.alexdev.cleannotes.android.presentation.note.note_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexdev.cleannotes.android.presentation.note.SearchBar
import com.alexdev.cleannotes.android.presentation.note.note_item.NoteItem
import org.koin.androidx.compose.getViewModel

@Composable
fun NoteListScreen(
  onNoteTapped: (Long?) -> Unit,
  viewModel: NoteListViewModel = getViewModel()
) {

  val state by viewModel.state.collectAsState()

  LaunchedEffect(key1 = null) {
    viewModel.loadNotes()
  }

  Scaffold(
    floatingActionButton = {
      FloatingActionButton(onClick = {
        onNoteTapped(-1L)
      }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "add note")
      }
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(padding)
    ) {

      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp)
      ) {
        if (!state.isSearching) {
          Text(
            text = "All Notes",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
              .weight(1f)
              .padding(horizontal = 8.dp, vertical = 12.dp)
          )
        }
        SearchBar(
          text = state.query,
          isSearching = state.isSearching,
          onSearch = { query ->
            viewModel.onSearch(query)
          },
          onSearchTapped = {
            viewModel.toggleIsSearching()
          },
          onCloseTapped = {
            viewModel.toggleIsSearching()
          }
        )
      }

      if (state.notes.isEmpty())
        Box(
          modifier = Modifier.fillMaxSize()
        ) {
          Text(
            text = "There are no notes yet\nAdd some note... :D",
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
          )
        }
      LazyColumn {
        items(items = state.notes) { note ->
          Box(modifier = Modifier.padding(12.dp)) {
            NoteItem(note,
              onNoteTapped = {
                onNoteTapped(it)
              },
              onDeleteTapped = { id ->
                viewModel.deleteNote(id)
              }
            )
          }
        }
      }
    }
  }
}

@Preview
@Composable
fun PreviewNoteListScreen() {
  NoteListScreen({})
}