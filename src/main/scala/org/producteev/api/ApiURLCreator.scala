package org.producteev.api

import java.net.URL

import org.producteev.misc.URLConnectionWrapper

class ApiURLCreator {
  val host = "https://api.producteev.com/"

  def create(path: String, parameter: String, format: String): URL = {
    new URL(host + path + "." + format + "?" + parameter)
  }

  def connection(path: String, parameter: String, format: String, requestMethod: String): URLConnectionWrapper = {
    new URLConnectionWrapper(create(path, parameter, format), requestMethod)
  }
}
