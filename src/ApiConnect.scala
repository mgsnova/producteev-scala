class ApiConnect(api_url_connection: ApiURLCreator) {
  def get(path: String, parameter: String, format: String): ApiResponse = {
    val urlconn = api_url_connection.connection(path, parameter, format)

    try {    
      new ApiResponse(urlconn.response_code, urlconn.input_string)
    } catch {
      case e: Exception => {
        new ApiResponse(urlconn.response_code, urlconn.error_string)
      }
    }
  }
}
