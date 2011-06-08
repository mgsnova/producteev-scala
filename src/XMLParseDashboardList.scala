object XMLParseDashboardList {
  def parse(xml_element: scala.xml.Node): List[Dashboard] = {
    xml_element match {
      case <dashboards>{dashboards@_*}</dashboards> => {
        dashboards.filter(dashboard => dashboard.child.size > 0).map(dashboard => XMLParseDashboard.parse(dashboard)).toList
      }
    }
  }
}
