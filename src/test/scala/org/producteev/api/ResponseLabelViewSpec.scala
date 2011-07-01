package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseLabelViewSpec extends Spec with ShouldMatchers {
  describe("ResponseLabelView") {
    val response = new ResponseLabelView("xml", new ApiResponse(200, TestXml.labelView))
 
    it("should return a label") {
      response.label.id_label should equal (323451)
      response.label.id_creator should equal (206530)
      response.label.id_dashboard should equal (243972)
      response.label.title should equal ("foo")
      response.label.color should equal ("#6D763E")
      response.label.label_type should equal (1)
      response.label.x should equal (-1)
      response.label.y should equal (-1)
      response.label.order should equal (-1)
      response.label.time_create should equal ("Wed, 11 May 2011 21:04:20 +0200")
      response.label.time_lastchange should equal ("Wed, 11 May 2011 21:04:20 +0200")
      response.label.from should equal ("")
      response.label.deleted should equal (0)
      response.label.order_position should equal (-1)
    }
  }
}
