import scala.collection.mutable.HashSet

class ResponseDashboardShowlist(format: String, response: ApiResponse) extends Response(format, response) {
  def dashboard_list: List[Dashboard] = {
    format match {
      case "xml" => XMLParseDashboardList.parse(xml_content)
    }
  }
}
