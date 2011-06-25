package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseNoteListSpec extends Spec with ShouldMatchers {
  describe("XMLParseNoteList") {
    val xmlElement = XML.loadString(TestXml.noteList)   

    it("should parse list of note out of xml tree") {
      val noteList = XMLParseNoteList.parse(xmlElement)
      noteList.size should equal(2)

      noteList.head.id_note should equal(1856485)
      noteList.head.message should equal("yes")

      noteList.last.id_note should equal(1856486)
      noteList.last.message should equal("no")
    }
  }
}
