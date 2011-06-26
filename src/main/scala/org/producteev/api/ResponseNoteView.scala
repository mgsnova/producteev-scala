package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Note
import org.producteev.xml.XMLParseNote

class ResponseNoteView(format: String, response: ApiResponse) extends Response(format, response) {
  def note: Note = {
    format match {
      case "xml" => return XMLParseNote.parse(xmlContent)
    }
  }
}
