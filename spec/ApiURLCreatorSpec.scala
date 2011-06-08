import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ApiURLCreatorSpec extends Spec with ShouldMatchers {
  describe("ApiURLCreator") {
    val url_creator = new ApiURLCreator

    it("should create an url") {
      val url = url_creator.create("path", "parameter", "format")
      url.toString should equal ("https://api.producteev.com/path.format?parameter")
    }

    it("should return a connection") {
      // TODO
    }
  }
}
