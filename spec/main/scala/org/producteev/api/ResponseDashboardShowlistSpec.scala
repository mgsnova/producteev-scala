package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

import org.producteev.TestXml

class ResponseDashboardShowlistSpec extends Spec with ShouldMatchers {
  describe("ResponseDashboardShowlistLogin") {
    val response = new ResponseDashboardShowlist("xml", new ApiResponse(200, TestXml.dashboardList))

    it("should return list of dashboards") {
      response.dashboard_list.size should equal(2)

      response.dashboard_list.head.id_dashboard should equal(243972)
      response.dashboard_list.head.title should equal("privat")

      response.dashboard_list.last.id_dashboard should equal(250322)
      response.dashboard_list.last.title should equal("second")
    }
  }
}
