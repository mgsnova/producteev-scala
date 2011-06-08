object XMLParseDashboard {
  def parse(xml_element: scala.xml.Node): Dashboard = {
    xml_element match {        
      case <node>{_}<dashboard>{entries@_*}</dashboard>{_}</node> => {
        var id_dashboard = -1
        var id_creator = -1
        var title = ""
        var write_ok = -1
        var time_lastchange = ""
        var status = -1
        var deleted = -1
        var smart_labels = -1
        var needs_upgrade = -1
        var accesslist: List[User] = List()

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
              accesslist = users.filter(user => user.child.size > 0).map(user => XMLParseUser.parse(user)).toList
            }           
            case _ =>
          }
        }
        return new Dashboard(id_dashboard, id_creator, title, write_ok, time_lastchange,
                             status, deleted, smart_labels, needs_upgrade, accesslist)
      }
    }
  }
}
