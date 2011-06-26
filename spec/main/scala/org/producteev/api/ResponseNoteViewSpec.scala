package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseNoteViewSpec extends Spec with ShouldMatchers {
  describe("ResponseNoteView") {
    val response = new ResponseNoteView("xml", new ApiResponse(200, TestXml.noteView))
 
    it("should return a note") {
      response.note.id_note should equal(1856485)
      response.note.id_task should equal(3254284)
      response.note.id_creator should equal(106536)
      response.note.message should equal("yes")
      response.note.file_url should equal("")
      response.note.file_name should equal("")
      response.note.time_create should equal("Sat, 25 Jun 2011 16:40:11 +0200")
      response.note.time_lastchange should equal("Sat, 26 Jun 2011 16:40:11 +0200")
      response.note.deleted should equal(0)
    }
  }
}
