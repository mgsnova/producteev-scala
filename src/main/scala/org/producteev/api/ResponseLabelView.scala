package org.producteev.api

import scala.collection.mutable.HashSet

import org.producteev.model.Label
import org.producteev.xml.XMLParseLabel

class ResponseLabelView(format: String, response: ApiResponse) extends Response(format, response) {
  def label: Label = {
    format match {
      case "xml" => return XMLParseLabel.parse(xmlContent)
    }
  }
}
