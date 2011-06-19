package org.producteev

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.io.Source

import org.producteev.api._

class SmokeSpec extends Spec with ShouldMatchers {
  describe("Testing against live api") {
    /* */
    it("should smoke") {
      val home = System.getProperty("user.home")
      val credentials = ApiCredentials.fromFiles(
        home + "/.producteev/api_key",
        home + "/.producteev/api_secret")

      val user = Source.fromFile(home + "/.producteev/user").mkString.stripLineEnd
      val pass = Source.fromFile(home + "/.producteev/pass").mkString.stripLineEnd

      val p = new Producteev(new ApiConnect(new ApiURLCreator), credentials, "xml")

      // do time call
      println(p.time.time)

      // do login
      val resLogin = p.usersLogin(user, pass)
      println(resLogin.token)
      println(resLogin.mail)

      // do dashboard show list
      val resDashboardList = p.dashboardsShowlist(resLogin.token)
      println(resDashboardList.dashboardList)
      println(resDashboardList.dashboardList.size)
      println(resDashboardList.dashboardList.head)
      println(resDashboardList.dashboardList.head.id_dashboard)
      resDashboardList.dashboardList.size should be (2)

      // do user view
      val resUser = p.usersView(resLogin.token)
      println(resUser.user)

      // do set default dashboard
      val resSetDefaultDashboard = p.usersSetDefaultDashboard(
        resLogin.token,
        resDashboardList.dashboardList.head.id_dashboard
      )
      println(resSetDefaultDashboard.user)

      // do dashboard view
      val resDashboardView = p.dashboardsView(
        resLogin.token,
        resDashboardList.dashboardList.head.id_dashboard
      )
      println(resDashboardView.dashboard)
      println(resDashboardView.dashboard.accesslist)

      // do dashboard create
      val resDashboardCreate = p.dashboardsCreate(
        resLogin.token,
        "testboard"
      )
      println(resDashboardCreate.dashboard)

      // do dashboard delete
      val resDashboardDelete = p.dashboardsDelete(
        resLogin.token,
        resDashboardCreate.dashboard.id_dashboard
      )
      println(resDashboardDelete.resultSuccess)

      // do users set sort by
      val resUserSetSortBy = p.usersSetSortBy(resLogin.token, 1)
      println(resUserSetSortBy.user)
      resUserSetSortBy.user.sort_by should be (1)

      // do users set timezone
      val resUserSetTimezone = p.usersSetTimezone(resLogin.token, "Europe/Berlin")
      println(resUserSetTimezone.user)
      resUserSetTimezone.user.timezone should be ("Europe/Berlin")

      // do dashboards set title
      val resDashboardSetTitle = p.dashboardsSetTitle(
        resLogin.token,
        resDashboardCreate.dashboard.id_dashboard,
        "blafasel"
      )
      println(resDashboardSetTitle.dashboard)
      resDashboardSetTitle.dashboard.title should be ("blafasel")

      // do dashboards set smart labels
      /* TODO not working
      val resDashboardSetSmartLabels = p.dashboardsSetSmartLabels(
        resLogin.token,
        resDashboardCreate.dashboard.id_dashboard,
        1
      )
      println(resDashboardSetSmartLabels.dashboard)
      */ 

      // do tasks show list
      val resTaskList = p.tasksShowlist(resLogin.token)
      println(resTaskList.taskList)

      // do task view
      val resTask = p.tasksView(resLogin.token, resTaskList.taskList.first.id_task)
      println(resTask.task)
      resTask.task.id_task should be (resTaskList.taskList.first.id_task)

      // do tasks my tasks 
      val resMyTaskList = p.tasksMyTasks(resLogin.token)
      println(resMyTaskList.taskList)

      // do tasks set title
      val resTaskSetTitle = p.tasksSetTitle(resLogin.token, resTask.task.id_task, "do it")
      println(resTaskSetTitle.task)
      resTaskSetTitle.task.title should be ("do it")

      // do tasks set status
      val resTaskSetStatus = p.tasksSetStatus(resLogin.token, resTask.task.id_task, 1)
      println(resTaskSetStatus.task)
      resTaskSetStatus.task.status should be (1)

      // do tasks set star
      val resTaskSetStar = p.tasksSetStar(resLogin.token, resTask.task.id_task, 3)
      println(resTaskSetStar.task)
      resTaskSetStar.task.star should be (3)
    }
    /* */
  }
}
