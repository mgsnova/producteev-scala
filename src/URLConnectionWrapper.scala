import java.net.{HttpURLConnection, URL}
import javax.net.ssl.HttpsURLConnection;
import io.Source

class URLConnectionWrapper(url: URL) {
  var connection = url.openConnection.asInstanceOf[HttpsURLConnection]
  connection.setRequestProperty("Accept-Charset", "utf-8");

  def input_string: String = Source.fromInputStream(connection.getInputStream).mkString
  def error_string: String = Source.fromInputStream(connection.getErrorStream).mkString
  def response_code: Int = connection.getResponseCode
}
