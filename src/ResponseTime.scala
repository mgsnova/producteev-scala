import scala.xml._

class ResponseTime(format: String, response: ApiResponse) extends Response(format, response) {
  def time(): String = {
    format match {
      case "xml" => (xml_content\\"time"\"value").text
    }
  }
}
