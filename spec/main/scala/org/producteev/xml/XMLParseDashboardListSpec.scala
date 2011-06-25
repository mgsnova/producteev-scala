package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseDashboardListSpec extends Spec with ShouldMatchers {
  describe("XMLParseDashboardList") {
    val xmlElement = XML.loadString(TestXml.dashboardList)   

    it("should parse list of dashboard out of xml tree") {
      val dashboardList = XMLParseDashboardList.parse(xmlElement)
      dashboardList.size should equal(2)

      dashboardList.head.id_dashboard should equal(243972)
      dashboardList.head.title should equal("privat")

      dashboardList.last.id_dashboard should equal(250322)
      dashboardList.last.title should equal("second")
    }
  }
}
