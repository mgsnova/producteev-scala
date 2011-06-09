package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseDashboardListSpec extends Spec with ShouldMatchers {
  describe("XMLParseDashboardList") {
    val xmlElement = XML.loadString(TestXml.dashboardList)   

    it("should parse list of dashboard out of xml tree") {
      val dashboard_list = XMLParseDashboardList.parse(xmlElement)
      dashboard_list.size should equal(2)

      dashboard_list.head.id_dashboard should equal(243972)
      dashboard_list.head.title should equal("privat")

      dashboard_list.last.id_dashboard should equal(250322)
      dashboard_list.last.title should equal("second")
    }
  }
}
