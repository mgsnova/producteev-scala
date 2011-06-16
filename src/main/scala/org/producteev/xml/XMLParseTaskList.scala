package org.producteev.xml

import org.producteev.model.Task

object XMLParseTaskList {
  def parse(xmlElement: scala.xml.Node): List[Task] = {
    xmlElement match {
      case <tasks>{tasks@_*}</tasks> => {
        tasks.filter(task => task.child.size > 0).map(task => XMLParseTask.parse(task)).toList
      }
    }
  }
}
