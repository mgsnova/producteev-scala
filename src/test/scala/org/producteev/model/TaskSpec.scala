package org.producteev.model

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class TaskSpec extends Spec with ShouldMatchers {
  describe("Task") {
    val task = new Task(
      1,
      2,
      3,
      4,
      -1,
      "Wed, 11 May 2011 21:05:48 +0200",
      "title",
      1,
      0,
      0,
      "",
      -1,
      0,
      "",
      1,
      0,
      0,
      0,
      123,
      "Wed, 11 May 2011 21:05:48 +0200",
      0,
      "",
      1,
      1,
      1,
      1,
      1,
      0,
      0,
      0,
      List(),
      List()
    )

    it("should return id_task") {
      task.id_task should equal(1)
    }
    
    it("should return id_dashboard") {
      task.id_dashboard should equal(2)
    }

    it("should return id_creator") {
      task.id_creator should equal(3)
    }

    it("should return id_responsible") {
      task.id_responsible should equal(4)
    }

    it("should return assign_by") {
      task.assign_by should equal(-1)
    }

    it("should return time_created") {
      task.time_created should equal("Wed, 11 May 2011 21:05:48 +0200")
    }

    it("should return title") {
      task.title should equal("title")
    }

    it("should return status") {
      task.status should equal(1)
    }

    it("should return star") {
      task.star should equal(0)
    }

    it("should return vote") {
      task.vote should equal(0)
    }

    it("should return deadline") {
      task.deadline should equal("")
    }

    it("should return all_day") {
      task.all_day should equal(-1)
    }

    it("should return reminder") {
      task.reminder should equal(0)
    }

    it("should return repeating_interval") {
      task.repeating_interval should equal("")
    }

    it("should return repeating_value") {
      task.repeating_value should equal(1)
    }

    it("should return hot") {
      task.hot should equal(0)
    }

    it("should return progression") {
      task.progression should equal(0)
    }

    it("should return public") {
      task.public should equal(0)
    }

    it("should return uid_lastchange") {
      task.uid_lastchange should equal(123)
    }

    it("should return time_lastchange") {
      task.time_lastchange should equal("Wed, 11 May 2011 21:05:48 +0200")
    }

    it("should return from") {
      task.from should equal(0)
    }

    it("should return time_status") {
      task.time_status should equal("")
    }

    it("should return r") {
      task.r should equal(1)
    }

    it("should return w") {
      task.w should equal(1)
    }

    it("should return x") {
      task.x should equal(1)
    }

    it("should return d") {
      task.d should equal(1)
    }

    it("should return viewed") {
      task.viewed should equal(1)
    }

    it("should return deleted") {
      task.deleted should equal(0)
    }

    it("should return nb_note") {
      task.nb_note should equal(0)
    }

    it("should return nb_new_note") {
      task.nb_new_note should equal(0)
    }

    it("should return labels") {
      task.labels.size should equal(0)
    }

    it("should return notes") {
      task.notes.size should equal(0)
    }
  }
}
