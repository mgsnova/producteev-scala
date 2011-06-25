package org.producteev.model

class Note(
  val id_note: Integer,
  val id_task: Integer,
  val id_creator: Integer,
  val message: String,
  val file_url: String,
  val file_name: String,
  val time_create: String,
  val time_lastchange: String,
  val deleted: Integer
)
