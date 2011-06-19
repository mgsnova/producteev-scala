package org.producteev.model

class Label(
  val id_label: Integer,
  val id_creator: Integer,
  val id_dashboard: Integer,
  val title: String,
  val color: String,
  val label_type: Integer,
  val x: Integer,
  val y: Integer,
  val order: Integer,
  val time_create: String,
  val time_lastchange: String,
  val from: String,
  val deleted: Integer,
  val order_position: Integer
)
