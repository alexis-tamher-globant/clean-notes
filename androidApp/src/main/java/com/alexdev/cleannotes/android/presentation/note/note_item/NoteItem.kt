package com.alexdev.cleannotes.android.presentation.note.note_item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alexdev.cleannotes.domain.model.Note
import com.alexdev.cleannotes.util.DateTimeUtil
import com.alexdev.cleannotes.util.randomColor

@Composable
fun NoteItem(
  note: Note,
  onNoteTapped: (Long) -> Unit = {},
  onDeleteTapped: (Long) -> Unit = {}
) {
  Box(
    modifier = Modifier
      .clip(RoundedCornerShape(5.dp))
      .fillMaxWidth()
      .background(Color(note.color))
      .clickable {
        onNoteTapped(note.id)
      }
      .padding(12.dp)
  ) {

    Column {
      Row(
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = note.title,
          fontSize = 20.sp,
          fontWeight = FontWeight.SemiBold,
          modifier = Modifier.weight(1f)
        )
        Icon(
          imageVector = Icons.Default.Close,
          contentDescription = "Delete note",
          modifier = Modifier
            .clip(RoundedCornerShape(18.dp))
            .clickable {
              onDeleteTapped(note.id)
            })
      }
      Text(text = note.content)
      Text(
        text = DateTimeUtil.formatNoteDate(note.date),
        textAlign = TextAlign.End,
        fontSize = 12.sp,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@Preview
@Composable
fun PreviewNoteItem() {
  Box(modifier = Modifier.size(400.dp, 300.dp)) {
    NoteItem(
      Note(
        ((1..20).random().toLong()),
        String(),
        String(),
        randomColor(),
        DateTimeUtil.now()
      )
    )
  }
}