package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml

class XMLParseTaskListSpec extends Spec with ShouldMatchers {
  describe("XMLParseTaskList") {
    val xmlElement = XML.loadString(TestXml.taskList)   

    it("should parse listaskss out of xml tree") {
      val task_list = XMLParseTaskList.parse(xmlElement)
      task_list.size should equal(2)

      task_list.head.id_task should equal(2377422)
      task_list.head.title should equal("blafasel")

      task_list.last.id_task should equal(2377423)
      task_list.last.title should equal("blafasel2")
    }
  }
}
