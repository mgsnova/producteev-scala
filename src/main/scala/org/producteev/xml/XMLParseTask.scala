package org.producteev.xml

import org.producteev.model.Task

object XMLParseTask {
  def parse(xmlElement: scala.xml.Node) = {
    var id_task = -1
    var id_dashboard = -1
    var id_creator = -1
    var id_responsible = -1
    var assign_by = -1
    var time_created = ""
    var title = ""
    var status = -1
    var star = -1
    var vote = -1
    var deadline = ""
    var all_day = -1
    var reminder = -1
    var repeating_interval = ""
    var repeating_value = -1
    var hot = -1
    var progression = -1
    var public = -1
    var uid_lastchange = -1
    var time_lastchange = ""
    var from = -1
    var time_status = ""
    var r = -1
    var w = -1
    var x = -1
    var d = -1
    var viewed = -1
    var deleted = -1
    var nb_note = -1
    var nb_new_note = -1

    val entries = xmlElement match {
      case <task>{entries@_*}</task> => entries
      case <node>{_}<task>{entries@_*}</task>{_}</node> => entries
      case <node><task>{entries@_*}</task></node> => entries
    }

    for (entry <- entries) {
      entry match {
        case <id_task>{_id_task}</id_task> => id_task = _id_task.text.toInt
        case <id_dashboard>{_id_dashboard}</id_dashboard> => id_dashboard = _id_dashboard.text.toInt
        case <id_creator>{_id_creator}</id_creator> => id_creator = _id_creator.text.toInt
        case <id_responsible>{_id_responsible}</id_responsible> => id_responsible = _id_responsible.text.toInt
        case <assign_by>{_assign_by}</assign_by> => assign_by = _assign_by.text.toInt
        case <time_created>{_time_created}</time_created> => time_created = _time_created.text
        case <title>{_title}</title> => title = _title.text
        case <status>{_status}</status> => status = _status.text.toInt
        case <star>{_star}</star> => star = _star.text.toInt
        case <vote>{_vote}</vote> => vote = _vote.text.toInt
        case <deadline>{_deadline}</deadline> => deadline = _deadline.text
        case <all_day>{_all_day}</all_day> => all_day = _all_day.text.toInt
        case <reminder>{_reminder}</reminder> => reminder = _reminder.text.toInt
        case <repeating_interval>{_repeating_interval}</repeating_interval> => repeating_interval = _repeating_interval.text
        case <repeating_value>{_repeating_value}</repeating_value> => repeating_value = _repeating_value.text.toInt
        case <hot>{_hot}</hot> => hot = _hot.text.toInt
        case <progression>{_progression}</progression> => progression = _progression.text.toInt
        case <public>{_public}</public> => public = _public.text.toInt
        case <uid_lastchange>{_uid_lastchange}</uid_lastchange> => uid_lastchange = _uid_lastchange.text.toInt
        case <time_lastchange>{_time_lastchange}</time_lastchange> => time_lastchange = _time_lastchange.text
        case <from>{_from}</from> => from = _from.text.toInt
        case <time_status>{_time_status}</time_status> => time_status = _time_status.text
        case <r>{_r}</r> => r = _r.text.toInt
        case <w>{_w}</w> => w = _w.text.toInt
        case <x>{_x}</x> => x = _x.text.toInt
        case <d>{_d}</d> => d = _d.text.toInt
        case <viewed>{_viewed}</viewed> => viewed = _viewed.text.toInt
        case <deleted>{_deleted}</deleted> => deleted = _deleted.text.toInt
        case <nb_note>{_nb_note}</nb_note> => nb_note = _nb_note.text.toInt
        case <nb_new_note>{_nb_new_note}</nb_new_note> => nb_new_note = _nb_new_note.text.toInt
        // TODO labels
        // TODO notes
        case _ => 
      }
    }

    new Task(id_task, id_dashboard, id_creator, id_responsible, assign_by, time_created, 
      title, status, star, vote, deadline, all_day, reminder, repeating_interval, 
      repeating_value, hot, progression, public, uid_lastchange, time_lastchange, 
      from, time_status, r, w, x, d, viewed, deleted, nb_note, nb_new_note)
  }
}
