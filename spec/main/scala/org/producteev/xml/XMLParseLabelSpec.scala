package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml
import org.producteev.model.Label

class XMLParseLabelSpec extends Spec with ShouldMatchers {
  describe("XMLParseLabel") {
    val xmlElementLabelListItem = XML.loadString(TestXml.labelListItem)   
    val xmlElementLabel = XML.loadString(TestXml.labelView)   

    def assertLabel(label: Label) {
      label.id_label should equal (323451)
      label.id_creator should equal (206530)
      label.id_dashboard should equal (243972)
      label.title should equal ("foo")
      label.color should equal ("#6D763E")
      label.label_type should equal (1)
      label.x should equal (-1)
      label.y should equal (-1)
      label.order should equal (-1)
      label.time_create should equal ("Wed, 11 May 2011 21:04:20 +0200")
      label.time_lastchange should equal ("Wed, 11 May 2011 21:04:20 +0200")
      label.from should equal ("")
      label.deleted should equal (0)
      label.order_position should equal (-1)
    }

    it("should parse xml tree (from list) to a label") {
      val label = XMLParseLabel.parse(xmlElementLabelListItem)
      assertLabel(label)
    }

    it("should parse xml tree (from view) to a label") {
      val label = XMLParseLabel.parse(xmlElementLabel)
      assertLabel(label)
    }
  }
}
