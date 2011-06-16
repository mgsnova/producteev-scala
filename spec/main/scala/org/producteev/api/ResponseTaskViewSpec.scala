package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseTaskViewSpec extends Spec with ShouldMatchers {
  describe("ResponseTaskView") {
    val response = new ResponseTaskView("xml", new ApiResponse(200, TestXml.taskView))
 
    it("should return a task") {
      response.task.id_task should be (2377422)
      response.task.id_dashboard should be (143972)
      response.task.id_creator should be (126530)
      response.task.id_responsible should be (106530)
      response.task.assign_by should be (-1)
      response.task.time_created should be ("Wed, 11 May 2011 21:06:50 +0200")
      response.task.title should be ("blafasel")
      response.task.status should be (1)
      response.task.star should be (0)
      response.task.vote should be (0)
      response.task.deadline should be ("")
      response.task.all_day should be (-1)
      response.task.reminder should be (0)
      response.task.repeating_interval should be (-1)
      response.task.repeating_value should be (1)
      response.task.hot should be (0)
      response.task.progression should be (0)
      response.task.public should be (0)
      response.task.uid_lastchange should be (106530)
      response.task.time_lastchange should be ("Wed, 11 May 2011 21:06:50 +0200")
      response.task.from should be (0)
      response.task.time_status should be ("")
      response.task.r should be (1)
      response.task.w should be (1)
      response.task.x should be (1)
      response.task.d should be (1)
      response.task.viewed should be (1)
      response.task.deleted should be (0)
      response.task.nb_note should be (0)
      response.task.nb_new_note should be (0)
    }
  }
}
