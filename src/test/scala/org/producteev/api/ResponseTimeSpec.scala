package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseTimeSpec extends Spec with ShouldMatchers {
  describe("ResponseTime") {
    it("should return time from parsed content") {
      val response = new ResponseTime("xml", new ApiResponse(200, TestXml.time))
      response.time should equal ("Mon, 23 May 2011 16:22:41 -0400")      
    }
  }
}
