package org.producteev.misc

import java.net.{HttpURLConnection, URL}
import javax.net.ssl.HttpsURLConnection;
import io.Source

class URLConnectionWrapper(url: URL) {
  var connection = url.openConnection.asInstanceOf[HttpsURLConnection]
  connection.setRequestProperty("Accept-Charset", "utf-8");

  def inputString: String = Source.fromInputStream(connection.getInputStream).mkString
  def errorString: String = {
    val errorStream = connection.getErrorStream
    if(errorStream == null) {
      Source.fromInputStream(errorStream).mkString
    } else {
      ""
    }
  }
  def responseCode: Int = connection.getResponseCode
}
