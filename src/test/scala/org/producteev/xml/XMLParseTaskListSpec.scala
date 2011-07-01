package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseTaskListSpec extends Spec with ShouldMatchers {
  describe("XMLParseTaskList") {
    val xmlElement = XML.loadString(TestXml.taskList)   

    it("should parse listaskss out of xml tree") {
      val taskList = XMLParseTaskList.parse(xmlElement)
      taskList.size should equal(2)

      taskList.head.id_task should equal(2377422)
      taskList.head.title should equal("blafasel")

      taskList.last.id_task should equal(2377423)
      taskList.last.title should equal("blafasel2")
    }
  }
}
