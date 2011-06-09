package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseDashboardSpec extends Spec with ShouldMatchers {
  describe("XMLParseDashboard") {
    val xmlElementListItem = XML.loadString(TestXml.dashboardListItem)   
    val xmlElementView = XML.loadString(TestXml.dashboardView)   

    it("should parse xml tree (from list) to a dashboard") {
      val dashboard = XMLParseDashboard.parse(xmlElementListItem)

      dashboard.id_dashboard should equal(250322)
      dashboard.id_creator should equal(106531)
      dashboard.title should equal("second")
      dashboard.write_ok should equal(1)
      dashboard.time_lastchange should equal("Wed, 25 May 2011 21:21:34 +0200")
      dashboard.status should equal(1)
      dashboard.deleted should equal(0)
      dashboard.smart_labels should equal(0)
      dashboard.needs_upgrade should equal(0)
      dashboard.accesslist.size should equal(1)
      dashboard.accesslist.head.id_user should equal(106531)
    }

    it("should parse xml tree (from view) to a dashboard") {
      val dashboard = XMLParseDashboard.parse(xmlElementView)

      dashboard.id_dashboard should equal(250322)
      dashboard.id_creator should equal(106531)
      dashboard.title should equal("second")
      dashboard.write_ok should equal(1)
      dashboard.time_lastchange should equal("Wed, 25 May 2011 21:21:34 +0200")
      dashboard.status should equal(1)
      dashboard.deleted should equal(0)
      dashboard.smart_labels should equal(0)
      dashboard.needs_upgrade should equal(0)
      dashboard.accesslist.size should equal(1)
      dashboard.accesslist.head.id_user should equal(106531)
    }
  }
}
