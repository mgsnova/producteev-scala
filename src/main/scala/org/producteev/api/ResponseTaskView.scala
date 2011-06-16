package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Task
import org.producteev.xml.XMLParseTask

class ResponseTaskView(format: String, response: ApiResponse) extends Response(format, response) {
  def task: Task = {
    format match {
      case "xml" => return XMLParseTask.parse(xmlContent)
    }
  }
}
