import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.io.Source

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

      val r = p.users_login(user, pass)
      println(r.token)
      println(r.mail)

      val d = p.dashboards_showlist(r.token)
      println(d.dashboard_list)
      println(d.dashboard_list.head)
      println(d.dashboard_list.head.id_dashboard)

      val u = p.users_view(r.token)
      println(u.user)

      val dd = p.users_set_default_dashboard(r.token, d.dashboard_list.head.id_dashboard)
      println(dd.user)

      //val dv = p.dashboards_view(r.token, d.dashboard_list.head.id_dashboard)
      //println(dv.dashboard_list.head)
    }
    /* */
  }
}
