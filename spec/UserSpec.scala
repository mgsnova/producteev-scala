import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class UserSpec extends Spec with ShouldMatchers {
  describe("User") {
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

    it("should return user id") {
      user.id_user should equal(1)
    }

    it("should return firstname") {
      user.firstname should equal("first")
    }

    it("should return lastname") {
      user.lastname should equal("last")
    }

    it("should return company") {
      user.company should equal("comp")
    }

    it("should return email") {
      user.email should equal("mail")
    }

    it("should return timezone") {
      user.timezone should equal("zone")
    }

    it("should return time_signup") {
      user.time_signup should equal("signup")
    }

    it("should return lang") {
      user.lang should equal(5)
    }

    it("should return avatar") {
      user.avatar should equal("avatar")
    }

    it("should return deleted") {
      user.deleted should equal(0)
    }

    it("should return default_dashboard") {
      user.default_dashboard should equal(1)
    }

    it("should return sort_by") {
      user.sort_by should equal(2)
    }

    it("should return dashboard_status") {
      user.dashboard_status should equal(4)
    }
  }
}
