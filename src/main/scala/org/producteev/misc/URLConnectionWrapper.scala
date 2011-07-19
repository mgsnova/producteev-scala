package org.producteev.misc

import java.net.{HttpURLConnection, URL}
import javax.net.ssl.HttpsURLConnection;
import io.Source

class URLConnectionWrapper(url: URL, requestMethod: String) {
  var connection = url.openConnection.asInstanceOf[HttpsURLConnection]
  connection.setRequestProperty("Accept-Charset", "utf-8");
  connection.setRequestMethod(requestMethod)

  def responseCode: Int = connection.getResponseCode
  def inputString: String = Source.fromInputStream(connection.getInputStream).mkString
  def errorString: String = Source.fromInputStream(connection.getErrorStream).mkString

  def input: String = {
    try {
      return inputString
    } catch {
      case e: Exception => {
        try {
          return errorString
        } catch {
          case e: Exception => {
            return ""
          }
        }
      }
    }
  }
}
