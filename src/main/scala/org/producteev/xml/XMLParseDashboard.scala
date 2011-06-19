package org.producteev.xml

import org.producteev.model.Dashboard
import org.producteev.model.User

object XMLParseDashboard {
  def parse(xmlElement: scala.xml.Node) = {
    var id_dashboard = -1
    var id_creator = -1
    var title = ""
    var write_ok = -1
    var time_lastchange = ""
    var status = -1
    var deleted = -1
    var smart_labels = -1
    var needs_upgrade = -1
    var accessList: List[User] = List()

    val entries = xmlElement match {
      case <dashboard>{entries@_*}</dashboard> => entries
      case <node>{_}<dashboard>{entries@_*}</dashboard>{_}</node> => entries
      case <node><dashboard>{entries@_*}</dashboard></node> => entries
    }

    for (entry <- entries) {
      entry match {
        case <id_dashboard>{_id_dashboard}</id_dashboard> => id_dashboard = _id_dashboard.text.toInt
        case <id_creator>{_id_creator}</id_creator> => id_creator = _id_creator.text.toInt
        case <title>{_title}</title> => title = _title.text
        case <write_ok>{_write_ok}</write_ok> => write_ok = _write_ok.text.toInt
        case <time_lastchange>{_time_lastchange}</time_lastchange> => time_lastchange = _time_lastchange.text
        case <status>{_status}</status> => status = _status.text.toInt
        case <deleted>{_deleted}</deleted> => deleted = _deleted.text.toInt
        case <smart_labels>{_smart_labels}</smart_labels> => smart_labels = _smart_labels.text.toInt
        case <needs_upgrade>{_needs_upgrade}</needs_upgrade> => needs_upgrade = _needs_upgrade.text.toInt
        case <accesslist>{users@_*}</accesslist> => {
          accessList = users.filter(user => user.child.size > 0).map(user => XMLParseUser.parse(user)).toList
        }           
        case _ =>
      }
    }

    new Dashboard(id_dashboard, id_creator, title, write_ok, time_lastchange,
                  status, deleted, smart_labels, needs_upgrade, accessList)
  }
}
