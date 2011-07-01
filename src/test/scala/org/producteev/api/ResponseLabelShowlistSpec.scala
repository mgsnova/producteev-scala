package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseLabelShowlistSpec extends Spec with ShouldMatchers {
  describe("ResponseLabelShowlistLogin") {
    val response = new ResponseLabelShowlist("xml", new ApiResponse(200, TestXml.labelList))

    it("should return list of labels") {
      response.labelList.size should equal(2)

      response.labelList.head.id_label should equal(323451)
      response.labelList.head.title should equal("foo")

      response.labelList.last.id_label should equal(323452)
      response.labelList.last.title should equal("foo2")
    }
  }
}
