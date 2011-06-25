package org.producteev.xml

import org.producteev.model.Note

object XMLParseNote {
  def parse(xmlElement: scala.xml.Node) = {
    var id_note = -1
    var id_task = -1
    var id_creator = -1
    var message = ""
    var file_url = ""
    var file_name = ""
    var time_create = ""
    var time_lastchange = ""
    var deleted = -1

    val entries = xmlElement match {
      case <note>{entries@_*}</note> => entries
      case <node>{_}<note>{entries@_*}</note>{_}</node> => entries
      case <node><note>{entries@_*}</note></node> => entries
    }

    for (entry <- entries) {
      entry match {
        case <id_note>{_id_note}</id_note> => id_note = _id_note.text.toInt
        case <id_task_ext>{_id_task}</id_task_ext> => id_task = _id_task.text.toInt
        case <id_creator>{_id_creator}</id_creator> => id_creator = _id_creator.text.toInt
        case <message>{_message}</message> => message = _message.text
        case <file_url>{_file_url}</file_url> => file_url = _file_url.text
        case <file_name>{_file_name}</file_name> => file_name = _file_name.text
        case <time_create>{_time_create}</time_create> => time_create = _time_create.text
        case <time_lastchange>{_time_lastchange}</time_lastchange> => time_lastchange = _time_lastchange.text
        case <deleted>{_deleted}</deleted> => deleted = _deleted.text.toInt
        case _ =>
      }
    }

    new Note(id_note, id_task, id_creator, message, file_url, file_name, time_create, time_lastchange, deleted)
  }
}
