import java.net.URL

class ApiURLCreator {
  val host = "https://api.producteev.com/"

  def create(path: String, parameter: String, format: String): URL = {
    new URL(host + path + "." + format + "?" + parameter)
  }

  def connection(path: String, parameter: String, format: String): URLConnectionWrapper = {
    new URLConnectionWrapper(create(path, parameter, format))
  }
}
