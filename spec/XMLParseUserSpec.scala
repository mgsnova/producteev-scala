import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

class XMLParseUserSpec extends Spec with ShouldMatchers {
  describe("XMLParseUser") {
    val xml_content1 = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <node>
        <user>
          <id_user>106531</id_user>
          <firstname>first</firstname>
          <lastname>last</lastname>
          <company>co</company>
          <email>mail@web.de</email>
          <timezone>Europe/Berlin</timezone>
          <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
          <lang>1</lang>
          <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
          <deleted>0</deleted>
          <default_dashboard>243972</default_dashboard>
          <sort_by>4</sort_by>
          <facebooks/>
          <colleagues/>
          <dashboard_status>1</dashboard_status>
        </user>
      </node>"""
    val xml_element1 = XML.loadString(xml_content1)   

    val xml_content2 = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <user>
        <id_user>106531</id_user>
        <firstname>first</firstname>
        <lastname>last</lastname>
        <company>co</company>
        <email>mail@web.de</email>
        <timezone>Europe/Berlin</timezone>
        <time_signup>Wed, 11 May 2011 20:57:15 +0200</time_signup>
        <lang>1</lang>
        <avatar>http://producteev.com//static/images/default-avatar.jpg</avatar>
        <deleted>0</deleted>
        <default_dashboard>243972</default_dashboard>
        <sort_by>4</sort_by>
        <facebooks/>
        <colleagues/>
      </user>"""
    val xml_element2 = XML.loadString(xml_content2)   

    it("should parse xml tree (from list) to a user") {
      val user = XMLParseUser.parse(xml_element1)

      user.id_user should equal (106531)
      user.firstname should equal ("first")
      user.lastname should equal ("last")
      user.company should equal ("co")
      user.email should equal ("mail@web.de")
      user.timezone should equal ("Europe/Berlin")
      user.time_signup should equal ("Wed, 11 May 2011 20:57:15 +0200")
      user.lang should equal (1)
      user.avatar should equal ("http://producteev.com//static/images/default-avatar.jpg")
      user.deleted should equal (0)
      user.default_dashboard should equal (243972)
      user.sort_by should equal (4)
      user.dashboard_status should equal (1)
    }

    it("should parse xml tree (from view) to a user") {
      val user = XMLParseUser.parse(xml_element2)

      user.id_user should equal (106531)
      user.firstname should equal ("first")
      user.lastname should equal ("last")
      user.company should equal ("co")
      user.email should equal ("mail@web.de")
      user.timezone should equal ("Europe/Berlin")
      user.time_signup should equal ("Wed, 11 May 2011 20:57:15 +0200")
      user.lang should equal (1)
      user.avatar should equal ("http://producteev.com//static/images/default-avatar.jpg")
      user.deleted should equal (0)
      user.default_dashboard should equal (243972)
      user.sort_by should equal (4)
    }
  }
}
