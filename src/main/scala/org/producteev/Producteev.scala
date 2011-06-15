package org.producteev

import org.producteev.api._

class Producteev(apiConnector: ApiConnect, credentials: ApiCredentials, format: String) {
  private def newReqParam: RequestParameters = {
    new RequestParameters(credentials.key, credentials.secret) 
  }

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

  def usersLogin(mail: String, pass: String): ResponseUserLogin = {
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
    dashboards/access
    dashboards/leave
    dashboards/set_title
    dashboards/set_smart_labels
    dashboards/delete
    dashboards/tasks
    dashboards/confirm
    dashboards/refuse
    dashboards/invite_user_by_id
    dashboards/invite_user_by_email
    dashboards/need_upgrade_list
    dashboards/needs_upgrade
    dashboards/access
  */

  def dashboardsCreate(token: String, title: String): ResponseDashboardView = {
    val params = newReqParam
    params.add("token", token)
    params.add("title", title)
    val res = apiConnector.get("dashboards/create", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  def dashboardsShowlist(token: String): ResponseDashboardShowlist = {
    val params = newReqParam
    params.add("token", token)
    val res = apiConnector.get("dashboards/show_list", params.urlParameter, format)
    new ResponseDashboardShowlist(format, res)
  }

  def dashboardsView(token: String, idDashboard: Integer): ResponseDashboardView = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("dashboards/view", params.urlParameter, format)
    new ResponseDashboardView(format, res)
  }

  def dashboardsDelete(token: String, idDashboard: Integer): ResponseStats = {
    val params = newReqParam
    params.add("token", token)
    params.add("id_dashboard", idDashboard.toString)
    val res = apiConnector.get("dashboards/delete", params.urlParameter, format)
    new ResponseStats(format, res)
  }

  // Tasks
  /* missing
    tasks/create
    tasks/view
    tasks/show_list
    tasks/archived
    tasks/set_title
    tasks/set_status
    tasks/set_star
    tasks/set_responsible
    tasks/unset_responsible
    tasks/set_deadline
    tasks/unset_deadline
    tasks/set_reminder
    tasks/set_repeating
    tasks/unset_repeating
    tasks/delete
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

  // Lables
  /* missing
    labels/view
    labels/show_list
    labels/create
    labels/delete
    labels/tasks
    labels/set_title
  */

  // Activities
  /* missing
    activities/show_activities
    activities/show_notifications
    activities/notifications_set_read
  */
}
