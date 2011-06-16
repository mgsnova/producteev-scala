package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Task
import org.producteev.xml.XMLParseTaskList

class ResponseTaskShowlist(format: String, response: ApiResponse) extends Response(format, response) {
  def task_list: List[Task] = {
    format match {
      case "xml" => XMLParseTaskList.parse(xmlContent)
    }
  }
}
