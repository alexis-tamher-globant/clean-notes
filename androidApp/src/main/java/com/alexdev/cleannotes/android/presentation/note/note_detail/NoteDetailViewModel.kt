package com.alexdev.cleannotes.android.presentation.note.note_detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexdev.cleannotes.domain.model.Note
import com.alexdev.cleannotes.domain.repository.NoteDataSource
import com.alexdev.cleannotes.util.DateTimeUtil
import com.alexdev.cleannotes.util.randomColor
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class NoteDetailViewModel(
  private val savedStateHandle: SavedStateHandle,
  private val dataSource: NoteDataSource
) : ViewModel() {
  private val title = savedStateHandle.getStateFlow("title", "")
  private val content = savedStateHandle.getStateFlow("content", "")
  private val color = savedStateHandle.getStateFlow(
    "color",
    randomColor()
  )
  private var currentId: Long = -1L

  val state = combine(title, content, color) { title, content, color ->
    NoteDetailState(title, content, color)
  }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteDetailState())


  fun updateTitle(title: String) {
    savedStateHandle["title"] = title
  }

  fun updateContent(content: String) {
    savedStateHandle["content"] = content
  }

  fun loadNote(noteId: Long) {
    viewModelScope.launch {
      dataSource.getNoteById(noteId)?.let { note ->
        currentId = note.id
        updateTitle(note.title)
        updateContent(note.content)
        savedStateHandle["color"] = note.color
      }
    }
  }

  fun saveNote() {
    viewModelScope.launch {
      dataSource.insertNote(
        Note(
          currentId,
          title.value,
          content.value,
          color.value,
          DateTimeUtil.now()
        )
      )
    }
  }
}