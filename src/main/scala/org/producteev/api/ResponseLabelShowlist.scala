package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Label
import org.producteev.xml.XMLParseLabelList

class ResponseLabelShowlist(format: String, response: ApiResponse) extends Response(format, response) {
  def labelList: List[Label] = {
    format match {
      case "xml" => XMLParseLabelList.parse(xmlContent)
    }
  }
}
