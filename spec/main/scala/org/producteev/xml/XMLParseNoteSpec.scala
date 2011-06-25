package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml
import org.producteev.model.Note

class XMLParseNoteSpec extends Spec with ShouldMatchers {
  describe("XMLParseNote") {
    val xmlElementListItem = XML.loadString(TestXml.noteListItem)   
    val xmlElementView = XML.loadString(TestXml.noteView)   

    def assertNote(note: Note) {
      note.id_note should equal(1856485)
      note.id_task should equal(3254284)
      note.id_creator should equal(106536)
      note.message should equal("yes")
      note.file_url should equal("")
      note.file_name should equal("")
      note.time_create should equal("Sat, 25 Jun 2011 16:40:11 +0200")
      note.time_lastchange should equal("Sat, 26 Jun 2011 16:40:11 +0200")
      note.deleted should equal(0)
    }

    it("should parse xml tree (from list) to a note") {
      val note = XMLParseNote.parse(xmlElementListItem)
      assertNote(note)
    }

    it("should parse xml tree (from view) to a note") {
      val note = XMLParseNote.parse(xmlElementView)
      assertNote(note)
    }
  }
}
