import scala.collection.mutable.HashSet

class ResponseUserView(format: String, response: ApiResponse) extends Response(format, response) {
  def user: User = {
    format match {
      case "xml" => return XMLParseUser.parse(xmlContent)
    }
  }
}
