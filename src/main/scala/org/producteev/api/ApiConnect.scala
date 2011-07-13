package org.producteev.api

class ApiConnect(apiUrlConnection: ApiURLCreator) {
  def get(path: String, parameter: String, format: String): ApiResponse = {
    val urlConn = apiUrlConnection.connection(path, parameter, format)

    try {    
      new ApiResponse(urlConn.responseCode, urlConn.input)
    } catch {
      case e: Exception => {
        val input = urlConn.input
        
        if(input.length > 0) {
          new ApiResponse(urlConn.responseCode, input)
        } else {
          new ApiResponse(urlConn.responseCode, "error" + e.getMessage.mkString)
        }
      }
    }
  }
}
