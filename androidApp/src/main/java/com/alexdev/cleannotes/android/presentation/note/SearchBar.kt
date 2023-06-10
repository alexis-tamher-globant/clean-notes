package com.alexdev.cleannotes.android.presentation.note

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
  text: String = "",
  isSearching: Boolean = false,
  onSearch: (String) -> Unit,
  onSearchTapped: () -> Unit,
  onCloseTapped: () -> Unit
) {
  Row(
    verticalAlignment = Alignment.CenterVertically
  ) {
    if (isSearching) {
      OutlinedTextField(
        value = text,
        onValueChange = onSearch,
        shape = RoundedCornerShape(10.dp),
        placeholder = { Text(text = "Search") },
        modifier = Modifier
          .padding(horizontal = 8.dp)
          .weight(1f)
      )
    }

    if (isSearching) {
      IconButton(
        onClick = { onCloseTapped() },
      ) {
        Icon(
          imageVector = Icons.Default.Close,
          contentDescription = "close searching",
        )
      }
    } else {
      IconButton(
        onClick = { onSearchTapped() },
      ) {
        Icon(
          imageVector = Icons.Default.Search,
          contentDescription = "search note",
        )
      }
    }

  }
}

@Preview
@Composable
fun PreviewSearchBar() {
  SearchBar("",false, {}, {}, {})
}