import scala.xml._

class ResponseUserLogin(format: String, response: ApiResponse) extends Response(format, response) {
  def token: String = {
    format match {
      case "xml" => (xmlContent\\"token").text
    }
  }

  def mail: String = {
    format match {
      case "xml" => (xmlContent\\"email").text
    }
  }
}
