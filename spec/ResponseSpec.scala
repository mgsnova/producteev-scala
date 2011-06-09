package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ResponseSpec extends Spec with ShouldMatchers {
  describe("Response") {
    val xmlContent = """<tag>foo</tag>"""
    val resSuccess = new Response("xml", new ApiResponse(200, xmlContent))
    val resError = new Response("xml", new ApiResponse(400, xmlContent))

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
