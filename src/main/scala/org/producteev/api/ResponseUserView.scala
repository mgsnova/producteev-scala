package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.User
import org.producteev.xml.XMLParseUser

class ResponseUserView(format: String, response: ApiResponse) extends Response(format, response) {
  def user: User = {
    format match {
      case "xml" => return XMLParseUser.parse(xmlContent)
    }
  }
}
