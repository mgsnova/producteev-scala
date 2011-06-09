package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Dashboard
import org.producteev.xml.XMLParseDashboard

class ResponseDashboardView(format: String, response: ApiResponse) extends Response(format, response) {
  def dashboard: Dashboard = {
    format match {
      case "xml" => return XMLParseDashboard.parse(xmlContent)
    }
  }
}
