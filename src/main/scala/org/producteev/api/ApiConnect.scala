package org.producteev.api

import org.producteev.misc.URLConnectionWrapper

class ApiConnect(apiUrlConnection: ApiURLCreator) {
  private def createResponse(urlConn: URLConnectionWrapper): ApiResponse = {
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

  private def createResponseDoubleTry(urlConn: URLConnectionWrapper): ApiResponse = {
    val response = createResponse(urlConn)
    if(response.code == -1) {
      createResponse(urlConn)
    } else {
      response
    }
  }

  def get(path: String, parameter: String, format: String): ApiResponse = {
    val urlConn = apiUrlConnection.connection(path, parameter, format, "GET")
    createResponseDoubleTry(urlConn)
  }
}
