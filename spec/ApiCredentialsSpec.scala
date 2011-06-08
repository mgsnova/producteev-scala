import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ApiCredentialsSpec extends Spec with ShouldMatchers {
  describe("ApiCredentials") {
    val credentials = new ApiCredentials("key", "secret")

    it("should return the api key") {
      credentials.key should equal ("key")
    }

    it("should return the api secret") {
      credentials.secret should equal ("secret")
    }

    it("should read credentials from files") {
      // TODO
    }
  }
}
