package org.producteev.xml

import org.producteev.model.Label

object XMLParseLabelList {
  def parse(xmlElement: scala.xml.Node): List[Label] = {
    xmlElement match {
      case <labels>{labels@_*}</labels> => {
        labels.filter(label => label.child.size > 0).map(label => XMLParseLabel.parse(label)).toList
      }
    }
  }
}
