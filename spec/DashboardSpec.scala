import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class DashboardSpec extends Spec with ShouldMatchers {
  describe("Dashboard") {
    val user = new User(
      1,
      "first",
      "last",
      "comp",
      "mail",
      "zone",
      "signup",
      5,
      "avatar",
      0,
      1,
      2,
      4
    )
    val dashboard = new Dashboard(
      1,
      2,
      "title",
      0,
      "last time changed",
      1,
      0,
      0,
      0,
      List(user)
    )

    it("should return dashboard id") {
      dashboard.id_dashboard should equal(1)
    }

    it("should return creator id") {
      dashboard.id_creator should equal(2)
    }

    it("should return titile") {
      dashboard.title should equal("title")
    }

    it("should return write_ok ") {
      dashboard.write_ok should equal(0)
    }

    it("should return time_lastchange") {
      dashboard.time_lastchange should equal("last time changed")
    }

    it("should return status") {
      dashboard.status should equal(1)
    }

    it("should return deleted") {
      dashboard.deleted should equal(0)
    }

    it("should return smart_labels") {
      dashboard.smart_labels should equal(0)
    }

    it("should return needs_upgrade") {
      dashboard.needs_upgrade should equal(0)
    }

    it("should return user accesslist") {
      dashboard.accesslist.size should equal(1)
      dashboard.accesslist.head.firstname should equal("first")
    }
  }
}
