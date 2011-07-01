package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseDashboardShowlistSpec extends Spec with ShouldMatchers {
  describe("ResponseDashboardShowlistLogin") {
    val response = new ResponseDashboardShowlist("xml", new ApiResponse(200, TestXml.dashboardList))

    it("should return list of dashboards") {
      response.dashboardList.size should equal(2)

      response.dashboardList.head.id_dashboard should equal(243972)
      response.dashboardList.head.title should equal("privat")

      response.dashboardList.last.id_dashboard should equal(250322)
      response.dashboardList.last.title should equal("second")
    }
  }
}
