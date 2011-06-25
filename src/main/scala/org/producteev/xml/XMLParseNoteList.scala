package org.producteev.xml

import org.producteev.model.Note

object XMLParseNoteList {
  def parse(xmlElement: scala.xml.Node): List[Note] = {
    xmlElement match {
      case <notes>{notes@_*}</notes> => {
        notes.filter(note => note.child.size > 0).map(note => XMLParseNote.parse(note)).toList
      }
    }
  }
}
