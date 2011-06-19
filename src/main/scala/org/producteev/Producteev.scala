package org.producteev

import org.producteev.api._

class Producteev(apiConnector: ApiConnect, credentials: ApiCredentials, format: String) {
  private def newReqParam: RequestParameters = {
    new RequestParameters(credentials.key, credentials.secret) 
  }

  // API from date 2011.06.19

  // Misc

  def time: ResponseTime = {
    val res = apiConnector.get("time", newReqParam.urlParameter, format)
    new ResponseTime(format, res)
  }

  // Users
  /* missing
    users/colleagues
    users/signup
    users/attach_facebook_id
    users/detach_facebook_id
    users/fblogin
  */

  def usersLogin(mail: String, pass: String) = {
    val params = newReqParam
    params.add("email", mail)
    params.add("password", pass)
    val res = apiConnector.get("users/login", params.urlParameter, format)
    new ResponseUserLogin(format, res)
  }
  
  def usersView(token: String, idColleague: Integer = -1) = {
    val params = newReqParam
    params.add("token", token)
    if (idColleague != -1) params.add("id_colleague", idColleague.toString)
    val res = apiConnector.get("users/view", params.urlParameter, format)
    new ResponseUserView(format, res)
  }

  def usersSetDefaultDashboard(token: String, idDashboard: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("users/set_default_dashboard", params.urlParameter, format)
    new ResponseUserView(format, res)
  }

  def usersSetSortBy(token: String, sort: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("sort", sort.toString)
    val res = apiConnector.get("users/set_sort_by", params.urlParameter, format)
    new ResponseUserView(format, res)
  }

  def usersSetTimezone(token: String, timezone: String) = {
    val params = newReqParam
    params.add("token", token)
    params.add("timezone", timezone)
    val res = apiConnector.get("users/set_timezone", params.urlParameter, format)
    new ResponseUserView(format, res)
  }

  // Dashboards
  /* missing
    dashboards/access -> included in dasboard/(view|show_list) ?
    dashboards/leave
    dashboards/tasks -> can be done with tasks/show_list ?
    dashboards/confirm
    dashboards/refuse
    dashboards/invite_user_by_id
    dashboards/invite_user_by_email
    dashboards/need_upgrade_list -> what for?
    dashboards/needs_upgrade -> what for?
  */

  def dashboardsCreate(token: String, title: String) = {
    val params = newReqParam
    params.add("token", token)
    params.add("title", title)
    val res = apiConnector.get("dashboards/create", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  def dashboardsShowlist(token: String /*, since: String, page: Integer*/) = {
    val params = newReqParam
    params.add("token", token)
    val res = apiConnector.get("dashboards/show_list", params.urlParameter, format)
    new ResponseDashboardShowlist(format, res)
  }

  def dashboardsView(token: String, idDashboard: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("dashboards/view", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  def dashboardsDelete(token: String, idDashboard: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("dashboards/delete", params.urlParameter, format)
    new ResponseStats(format, res)
  }

  def dashboardsSetTitle(token: String, idDashboard: Integer, title: String) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    params.add("title", title)
    val res = apiConnector.get("dashboards/set_title", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  def dashboardsSetSmartLabels(token: String, idDashboard: Integer, set: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    params.add("value", set.toString)
    val res = apiConnector.get("dashboards/set_smart_labels", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  // Tasks
  /* missing
    tasks/archived
    tasks/my_team_tasks
    tasks/set_responsible
    tasks/unset_responsible
    tasks/set_repeating
    tasks/unset_repeating
    dashboards/access -> included in dashboards/(view|show_list) ?
    tasks/labels
    tasks/change_labels
    tasks/set_workspace
    tasks/privacy
    tasks/note_view
    tasks/notes_get
    tasks/note_create
    tasks/note_delete
    tasks/activity_view
    tasks/activities_get
  */

  def tasksCreateSimple(token: String, title: String, idDashboard: Integer = -1) = {
    val params = newReqParam
    params.add("token", token)
    params.add("title", title)
    if (idDashboard != -1) params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("tasks/create", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksDelete(token: String, idTask: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    val res = apiConnector.get("tasks/delete", params.urlParameter, format)
    new ResponseStats(format, res)
  }

  def tasksShowlist(token: String, idDashboard: Integer = -1 /*, since: String, page: Integer*/) = {
    val params = newReqParam
    params.add("token", token)
    if (idDashboard != -1) params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("tasks/show_list", params.urlParameter, format)
    new ResponseTaskShowlist(format, res)
  }

  def tasksView(token: String, idTask: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    val res = apiConnector.get("tasks/view", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksMyTasks(token: String /*, since: String, page: Integer*/) = {
    val params = newReqParam
    params.add("token", token)
    val res = apiConnector.get("tasks/my_tasks", params.urlParameter, format)
    new ResponseTaskShowlist(format, res)
  }

  def tasksSetTitle(token: String, idTask: Integer, title: String) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    params.add("title", title)
    val res = apiConnector.get("tasks/set_title", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksSetStatus(token: String, idTask: Integer, status: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    params.add("status", status.toString)
    val res = apiConnector.get("tasks/set_status", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksSetStar(token: String, idTask: Integer, star: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    params.add("star", star.toString)
    val res = apiConnector.get("tasks/set_star", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksSetDeadline(token: String, idTask: Integer, deadline: String, allDay: Integer = 0) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    params.add("deadline", deadline)
    params.add("all_day", allDay.toString)
    val res = apiConnector.get("tasks/set_deadline", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  def tasksUnsetDeadline(token: String, idTask: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    val res = apiConnector.get("tasks/unset_deadline", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }
  
  def tasksSetReminder(token: String, idTask: Integer, reminder: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_task", idTask.toString)
    params.add("reminder", reminder.toString)
    val res = apiConnector.get("tasks/set_reminder", params.urlParameter, format)
    new ResponseTaskView(format, res)
  }

  // Lables
  /* missing
    labels/create
    labels/delete
    labels/tasks
    labels/set_title
  */

  def labelsView(token: String, idLabel: Integer) = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_label", idLabel.toString)
    val res = apiConnector.get("labels/view", params.urlParameter, format)
    new ResponseLabelView(format, res)
  }

  def labelsShowlist(token: String /*, since: String, page: Integer*/) = {
    val params = newReqParam
    params.add("token", token)
    val res = apiConnector.get("labels/show_list", params.urlParameter, format)
    new ResponseLabelShowlist(format, res)
  }

  // Activities
  /* missing
    activities/show_activities
    activities/show_notifications
    activities/notifications_set_read
  */
}
