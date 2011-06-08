object XMLParseUser {
  def parse(xml_element: scala.xml.Node): User = {
    var id_user = -1
    var firstname = ""
    var lastname = ""
    var company = ""
    var email = ""
    var timezone = ""
    var time_signup = ""
    var lang = 1
    var avatar = ""
    var deleted = -1
    var default_dashboard = -1
    var sort_by = -1
    var dashboard_status = -1

    val entries = xml_element match {
      case <user>{entries@_*}</user> => entries
      case <node>{_}<user>{entries@_*}</user>{_}</node> => entries
    }

    for (entry <- entries) {
      entry match {
        case <id_user>{_id_user}</id_user> => id_user = _id_user.text.toInt
        case <firstname>{_firstname}</firstname> => firstname = _firstname.text
        case <lastname>{_lastname}</lastname> => lastname = _lastname.text
        case <company>{_company}</company> => company = _company.text
        case <email>{_email}</email> => email = _email.text
        case <timezone>{_timezone}</timezone> => timezone = _timezone.text
        case <time_signup>{_time_signup}</time_signup> => time_signup = _time_signup.text
        case <lang>{_lang}</lang> => lang = _lang.text.toInt
        case <avatar>{_avatar}</avatar> => avatar = _avatar.text
        case <deleted>{_deleted}</deleted> => deleted = _deleted.text.toInt
        case <default_dashboard>{_default_dashboard}</default_dashboard> => default_dashboard = _default_dashboard.text.toInt
        case <sort_by>{_sort_by}</sort_by> => sort_by = _sort_by.text.toInt
        case <dashboard_status>{_dashboard_status}</dashboard_status> => dashboard_status = _dashboard_status.text.toInt
        // TODO facebooks
        // TODO colleagues
        case _ => 
      }
    }

    new User(id_user, firstname, lastname, company, email, timezone, time_signup,
             lang, avatar, deleted, default_dashboard, sort_by, dashboard_status)
  }
}
