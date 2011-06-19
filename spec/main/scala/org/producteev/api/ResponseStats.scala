package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseStatsSpec extends Spec with ShouldMatchers {
  describe("ResponseStats") {
    it("should return true for successfully deleted dashboard") {
      val response = new ResponseStats("xml", new ApiResponse(200, TestXml.statsSuccess))
      response.resultSuccess should be (true) 
    }

    it("should return false for not successfully deleted dashboard") {
      val response = new ResponseStats("xml", new ApiResponse(200, TestXml.statsFailure))
      response.resultSuccess should be (false) 
    }
  }
}
