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

      println(p.time.time)

      val r = p.usersLogin(user, pass)
      println(r.token)
      println(r.mail)

      val d = p.dashboardsShowlist(r.token)
      println(d.dashboard_list)
      println(d.dashboard_list.head)
      println(d.dashboard_list.head.id_dashboard)

      val u = p.usersView(r.token)
      println(u.user)

      val dd = p.usersSetDefaultDashboard(r.token, d.dashboard_list.head.id_dashboard)
      println(dd.user)

      val dv = p.dashboardsView(r.token, d.dashboard_list.head.id_dashboard)
      //println(dv.dashboard_list.head)
    }
    /* */
  }
}
