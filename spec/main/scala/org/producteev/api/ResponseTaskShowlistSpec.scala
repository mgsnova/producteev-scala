package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseTaskShowlistSpec extends Spec with ShouldMatchers {
  describe("ResponseTaskShowlistLogin") {
    val response = new ResponseTaskShowlist("xml", new ApiResponse(200, TestXml.taskList))

    it("should return list of tasks") {
      response.task_list.size should equal(2)

      response.task_list.head.id_task should equal(2377422)
      response.task_list.head.title should equal("blafasel")

      response.task_list.last.id_task should equal(2377423)
      response.task_list.last.title should equal("blafasel2")
    }
  }
}
