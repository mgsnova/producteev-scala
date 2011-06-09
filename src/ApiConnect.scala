package org.producteev.api

class ApiConnect(apiUrlConnection: ApiURLCreator) {
  def get(path: String, parameter: String, format: String): ApiResponse = {
    val urlConn = apiUrlConnection.connection(path, parameter, format)

    try {    
      new ApiResponse(urlConn.responseCode, urlConn.inputString)
    } catch {
      case e: Exception => {
        new ApiResponse(urlConn.responseCode, urlConn.errorString)
      }
    }
  }
}
