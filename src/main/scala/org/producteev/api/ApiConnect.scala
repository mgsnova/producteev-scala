package org.producteev.api

class ApiConnect(apiUrlConnection: ApiURLCreator) {
  def get(path: String, parameter: String, format: String): ApiResponse = {
    val urlConn = apiUrlConnection.connection(path, parameter, format)

    try {    
      new ApiResponse(urlConn.responseCode, urlConn.inputString)
    } catch {
      case e: Exception => {
        if(urlConn.responseCode > 0) {
          new ApiResponse(urlConn.responseCode, urlConn.errorString)
        } else {
          new ApiResponse(urlConn.responseCode, "error: " + e.getMessage.mkString)
        }
      }
    }
  }
}
