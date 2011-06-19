package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseLabelListSpec extends Spec with ShouldMatchers {
  describe("XMLParseLabelList") {
    val xmlElement = XML.loadString(TestXml.labelList)   

    it("should parse list of labels out of xml tree") {
      val label_list = XMLParseLabelList.parse(xmlElement)
      label_list.size should equal(2)

      label_list.head.id_label should equal(323451)
      label_list.head.title should equal("foo")

      label_list.last.id_label should equal(323452)
      label_list.last.title should equal("foo2")
    }
  }
}
