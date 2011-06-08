import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class ResponseTimeSpec extends Spec with ShouldMatchers {
  describe("ResponseTime") {
    it("should return time from parsed content") {
      val xml_content = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <time>
        <value>Mon, 23 May 2011 16:22:41 -0400</value>
      </time>"""
      val response = new ResponseTime("xml", new ApiResponse(200, xml_content))
      response.time should equal ("Mon, 23 May 2011 16:22:41 -0400")      
    }
  }
}
