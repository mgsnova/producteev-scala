package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseSpec extends Spec with ShouldMatchers {
  describe("Response") {
    val resSuccess = new Response("xml", new ApiResponse(200, TestXml.dummy))
    val resError = new Response("xml", new ApiResponse(400, TestXml.dummy))

    it("should indicate success on success") {
     resSuccess.success should be (true)
    } 

    it("should not indicate success on error") {
     resError.success should be (false)
    } 

    it("should indicate error on error") {
     resError.error should be (true)
    } 

    it("should not indicate error on success") {
     resSuccess.error should be (false)
    } 
  }
}
