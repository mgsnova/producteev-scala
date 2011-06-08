import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ResponseUserLoginSpec extends Spec with ShouldMatchers {
  describe("ResponseUserLogin") {
    val xml_content = """<login>
       <token>a_session_token</token>
       <email>user@provider.com</email>
     </login>"""
    val response = new ResponseUserLogin("xml", new ApiResponse(200, xml_content))

    it("should return token from parsed content") {
      response.token should equal ("a_session_token")
    }

    it("should return mail from parsed content") {
      response.mail should equal ("user@provider.com")
    }
  }
}
