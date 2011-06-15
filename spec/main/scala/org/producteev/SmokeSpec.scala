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
      println(resDashboardList.dashboard_list)
      println(resDashboardList.dashboard_list.size)
      println(resDashboardList.dashboard_list.head)
      println(resDashboardList.dashboard_list.head.id_dashboard)
      // resDashboardList.dashboard_list.size should be (2)

      // do user view
      val resUser = p.usersView(resLogin.token)
      println(resUser.user)

      // do set default dashboard
      val resSetDefaultDashboard = p.usersSetDefaultDashboard(
        resLogin.token,
        resDashboardList.dashboard_list.head.id_dashboard
      )
      println(resSetDefaultDashboard.user)

      // do dashboard view
      val resDashboardView = p.dashboardsView(
        resLogin.token,
        resDashboardList.dashboard_list.head.id_dashboard
      )
      println(resDashboardView.dashboard)

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

      // do users set timezone
      val resUserSetTimezone = p.usersSetTimezone(resLogin.token, "Europe/Berlin")
      println(resUserSetTimezone.user)
    }
    /* */
  }
}
