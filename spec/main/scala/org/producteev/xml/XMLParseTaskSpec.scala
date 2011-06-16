package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml
import org.producteev.model.Task

class XMLParseTaskSpec extends Spec with ShouldMatchers {
  describe("XMLParseUser") {
    val xmlElementTaskListItem = XML.loadString(TestXml.taskListItem)   
    val xmlElementTask = XML.loadString(TestXml.taskView)   

    def assertTask(task: Task) {
      task.id_task should be (2377422)
      task.id_dashboard should be (143972)
      task.id_creator should be (126530)
      task.id_responsible should be (106530)
      task.assign_by should be (-1)
      task.time_created should be ("Wed, 11 May 2011 21:06:50 +0200")
      task.title should be ("blafasel")
      task.status should be (1)
      task.star should be (0)
      task.vote should be (0)
      task.deadline should be ("")
      task.all_day should be (-1)
      task.reminder should be (0)
      task.repeating_interval should be (-1)
      task.repeating_value should be (1)
      task.hot should be (0)
      task.progression should be (0)
      task.public should be (0)
      task.uid_lastchange should be (106530)
      task.time_lastchange should be ("Wed, 11 May 2011 21:06:50 +0200")
      task.from should be (0)
      task.time_status should be ("")
      task.r should be (1)
      task.w should be (1)
      task.x should be (1)
      task.d should be (1)
      task.viewed should be (1)
      task.deleted should be (0)
      task.nb_note should be (0)
      task.nb_new_note should be (0)
    }

    it("should parse xml tree (from list) to a task") {
      val task = XMLParseTask.parse(xmlElementTaskListItem)
      assertTask(task)
    }

    it("should parse xml tree (from view) to a task") {
      val task = XMLParseTask.parse(xmlElementTask)
      assertTask(task)
    }
  }
}
