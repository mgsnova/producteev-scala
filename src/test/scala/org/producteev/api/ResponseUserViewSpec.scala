package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseUserViewSpec extends Spec with ShouldMatchers {
  describe("ResponseUserView") {
    val response = new ResponseUserView("xml", new ApiResponse(200, TestXml.userView))
 
    it("should return a user") {
      response.user.id_user should equal (106531)
      response.user.firstname should equal ("first")
      response.user.lastname should equal ("last")
      response.user.company should equal ("co")
      response.user.email should equal ("mail@web.de")
      response.user.timezone should equal ("Europe/Berlin")
      response.user.time_signup should equal ("Wed, 11 May 2011 20:57:15 +0200")
      response.user.lang should equal (1)
      response.user.avatar should equal ("http://producteev.com//static/images/default-avatar.jpg")
      response.user.deleted should equal (0)
      response.user.default_dashboard should equal (243972)
      response.user.sort_by should equal (4)
    }
  }
}
