package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Dashboard
import org.producteev.xml.XMLParseDashboardList

class ResponseDashboardShowlist(format: String, response: ApiResponse) extends Response(format, response) {
  def dashboardList: List[Dashboard] = {
    format match {
      case "xml" => XMLParseDashboardList.parse(xmlContent)
    }
  }
}
