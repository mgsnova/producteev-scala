import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ApiResponseSpec extends Spec with ShouldMatchers {
  describe("ApiResponse") {
    val response = new ApiResponse(404, "not found")

    it("should return an api response code") {
      response.code should equal (404)
    }

    it("should return an api response content") {
      response.content should equal ("not found")
    }
  }
}
