package org.producteev.xml

import org.producteev.model.Dashboard

object XMLParseDashboardList {
  def parse(xmlElement: scala.xml.Node): List[Dashboard] = {
    xmlElement match {
      case <dashboards>{dashboards@_*}</dashboards> => {
        dashboards.filter(dashboard => dashboard.child.size > 0).map(dashboard => XMLParseDashboard.parse(dashboard)).toList
      }
    }
  }
}
