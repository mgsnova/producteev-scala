package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseDashboardViewSpec extends Spec with ShouldMatchers {
  describe("ResponseDashboardView") {
    val response = new ResponseDashboardView("xml", new ApiResponse(200, TestXml.dashboardView))
 
    it("should return a dashboard") {
      response.dashboard.id_dashboard should equal(250322)
      response.dashboard.id_creator should equal(106531)
      response.dashboard.title should equal("second")
      response.dashboard.write_ok should equal(1)
      response.dashboard.time_lastchange should equal("Wed, 25 May 2011 21:21:34 +0200")
      response.dashboard.status should equal(1)
      response.dashboard.deleted should equal(0)
      response.dashboard.smart_labels should equal(0)
      response.dashboard.needs_upgrade should equal(0)
      response.dashboard.accesslist.size should equal(1)
      response.dashboard.accesslist.head.id_user should equal(106531)
    }
  }
}
