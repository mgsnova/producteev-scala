package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseLabelListSpec extends Spec with ShouldMatchers {
  describe("XMLParseLabelList") {
    val xmlElement = XML.loadString(TestXml.labelList)   

    it("should parse list of labels out of xml tree") {
      val labelList = XMLParseLabelList.parse(xmlElement)
      labelList.size should equal(2)

      labelList.head.id_label should equal(323451)
      labelList.head.title should equal("foo")

      labelList.last.id_label should equal(323452)
      labelList.last.title should equal("foo2")
    }
  }
}
