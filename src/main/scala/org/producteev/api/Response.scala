package org.producteev.api

import scala.xml._

class Response(format: String, response: ApiResponse) {
  val xmlContent = format match {
    case "xml" => XML.loadString(response.content.trim)
  }

  def success: Boolean = {
    response.code >= 200 && response.code < 300 
  }

  def error: Boolean = {
    response.code >= 300
  }
}
