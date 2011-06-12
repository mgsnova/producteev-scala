package org.producteev.api

import scala.xml._

class ResponseStats(format: String, response: ApiResponse) extends Response(format, response) {
  def resultSuccess: Boolean = {
    var result = "FALSE"

    format match {
      case "xml" => result = (xmlContent\\"stats"\"result").text
    }

    result == "TRUE"
  }
}
