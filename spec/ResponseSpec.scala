import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ResponseSpec extends Spec with ShouldMatchers {
  describe("Response") {
    val xml_content = """<tag>foo</tag>"""
    val res_success = new Response("xml", new ApiResponse(200, xml_content))
    val res_error = new Response("xml", new ApiResponse(400, xml_content))

    it("should indicate success on success") {
     res_success.success should be (true)
    } 

    it("should not indicate success on error") {
     res_error.success should be (false)
    } 

    it("should indicate error on error") {
     res_error.error should be (true)
    } 

    it("should not indicate error on success") {
     res_success.error should be (false)
    } 
  }
}
