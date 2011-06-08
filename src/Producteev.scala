class Producteev(api_connector: ApiConnect, credentials: ApiCredentials, format: String) {
  private def new_req_param(): RequestParameters = {
    new RequestParameters(credentials.key, credentials.secret) 
  }

  // Misc

  def time(): ResponseTime = {
    val res = api_connector.get("time", new_req_param.url_parameter, format)
    new ResponseTime(format, res)
  }

  // Users
  /* missing
    users/colleagues
    users/signup
    users/attach_facebook_id
    users/detach_facebook_id
    users/fblogin
    users/set_sort_by
    users/set_timezone
  */

  def users_login(mail: String, pass: String): ResponseUserLogin = {
    val params = new_req_param
    params.add("email", mail)
    params.add("password", pass)
    val res = api_connector.get("users/login", params.url_parameter, format)
    new ResponseUserLogin(format, res)
  }
  
  def users_view(token: String, id_colleague: Integer = -1) = {
    val params = new_req_param
    params.add("token", token)
    if (id_colleague != -1) params.add("id_colleague", id_colleague.toString)
    val res = api_connector.get("users/view", params.url_parameter, format)
    new ResponseUserView(format, res)
  }

  def users_set_default_dashboard(token: String, id_dashboard: Integer) = {
    val params = new_req_param
    params.add("token", token)
    params.add("id_dashboard", id_dashboard.toString)
    val res = api_connector.get("users/set_default_dashboard", params.url_parameter, format)
    new ResponseUserView(format, res)
  }

  // Dashboards
  /* missing
    dashboards/create
    dashboards/view
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

  def dashboards_showlist(token: String): ResponseDashboardShowlist = {
    val params = new_req_param
    params.add("token", token)
    val res = api_connector.get("dashboards/show_list", params.url_parameter, format)
    new ResponseDashboardShowlist(format, res)
  }

  def dashboards_view(token: String, id_dashboard: Integer): ResponseDashboardShowlist = {
    val params = new_req_param
    params.add("token", token)
    params.add("id_dashboard", id_dashboard.toString)
    val res = api_connector.get("dashboards/view", params.url_parameter, format)
    new ResponseDashboardShowlist(format, res)
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
