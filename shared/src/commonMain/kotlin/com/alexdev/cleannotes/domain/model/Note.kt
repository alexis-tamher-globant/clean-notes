package com.alexdev.cleannotes.domain.model

import kotlinx.datetime.LocalDateTime


data class Note (
  val id: Long = -1,
  val title: String,
  val content: String,
  val color: Long,
  val date: LocalDateTime,
)

