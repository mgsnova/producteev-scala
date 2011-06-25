package org.producteev.model

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class NoteSpec extends Spec with ShouldMatchers {
  describe("Note") {
    val note = new Note(
      1,
      2,
      3,
      "hello",
      "url",
      "name",
      "Sat, 25 Jun 2011 16:40:11 +0200",
      "Sat, 25 Jun 2011 16:40:12 +0200",
      0
    )

    it("should return note id") {
      note.id_note should equal(1)
    }

    it("should return task id") {
      note.id_task should equal(2)
    }

    it("should return creator id") {
      note.id_creator should equal(3)
    }

    it("should return message") {
      note.message should equal("hello")
    }

    it("should return file url") {
      note.file_url should equal("url")
    }

    it("should return file name") {
      note.file_name should equal("name")
    }

    it("should return time created") {
      note.time_create should equal("Sat, 25 Jun 2011 16:40:11 +0200")
    }

    it("should return time lastchanged") {
      note.time_lastchange should equal("Sat, 25 Jun 2011 16:40:12 +0200")
    }

    it("should return deleted") {
      note.deleted should equal(0)
    }
  }
}
