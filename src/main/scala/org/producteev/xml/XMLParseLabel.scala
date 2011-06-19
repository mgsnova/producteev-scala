package org.producteev.xml

import org.producteev.model.Label

object XMLParseLabel {
  def parse(xmlElement: scala.xml.Node) = {
    var id_label = -1
    var id_creator = -1
    var id_dashboard = -1
    var title = ""
    var color = ""
    var label_type = -1
    var x = -1
    var y = -1
    var order = -1
    var time_create = ""
    var time_lastchange = ""
    var from = ""
    var deleted = -1
    var order_position = -1

    val entries = xmlElement match {
      case <label>{entries@_*}</label> => entries
      case <node>{_}<label>{entries@_*}</label>{_}</node> => entries
      case <node><label>{entries@_*}</label></node> => entries
    }

    for (entry <- entries) {
      entry match {
        case <id_label>{_id_label}</id_label> => id_label = _id_label.text.toInt
        case <id_creator>{_id_creator}</id_creator> => id_creator = _id_creator.text.toInt
        case <id_dashboard>{_id_dashboard}</id_dashboard> => id_dashboard = _id_dashboard.text.toInt
        case <title>{_title}</title> => title = _title.text
        case <color>{_color}</color> => color = _color.text
        case <type>{_label_type}</type> => label_type = _label_type.text.toInt
        case <x>{_x}</x> => x = _x.text.toInt
        case <y>{_y}</y> => y = _y.text.toInt
        case <order>{_order}</order> => order = _order.text.toInt
        case <time_create>{_time_create}</time_create> => time_create = _time_create.text
        case <time_lastchange>{_time_lastchange}</time_lastchange> => time_lastchange = _time_lastchange.text
        case <from>{_from}</from> => from = _from.text
        case <deleted>{_deleted}</deleted> => deleted = _deleted.text.toInt
        case <order_position>{_order_position}</order_position> => order_position = _order_position.text.toInt
        case _ => 
      }
    }

    new Label(id_label, id_creator, id_dashboard, title, color, label_type, x, y,
              order, time_create, time_lastchange, from, deleted, order_position)
  }
}

// vim: set ts=4 sw=4 et:
