import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

class XMLParseDashboardSpec extends Spec with ShouldMatchers {
  describe("XMLParseDashboard") {
    val xml_content = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <node>
        <dashboard>
          <id_dashboard>250322</id_dashboard>
          <id_creator>106531</id_creator>
          <title>second</title>
          <write_ok>1</write_ok>
          <time_lastchange>Wed, 25 May 2011 21:21:34 +0200</time_lastchange>
          <status>1</status>
          <deleted>0</deleted>
          <smart_labels>0</smart_labels>
          <needs_upgrade>0</needs_upgrade>
          <accesslist>
            <node>
              <user>
                <id_user>106531</id_user>
                <firstname>first</firstname>
                <lastname>last</lastname>
                <company/>
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
            </node>
          </accesslist>
        </dashboard>
      </node>"""
    val xml_element = XML.loadString(xml_content)   

    it("should parse xml tree to a dashboard") {
      val dashboard = XMLParseDashboard.parse(xml_element)

      dashboard.id_dashboard should equal(250322)
      dashboard.id_creator should equal(106531)
      dashboard.title should equal("second")
      dashboard.write_ok should equal(1)
      dashboard.time_lastchange should equal("Wed, 25 May 2011 21:21:34 +0200")
      dashboard.status should equal(1)
      dashboard.deleted should equal(0)
      dashboard.smart_labels should equal(0)
      dashboard.needs_upgrade should equal(0)
      dashboard.accesslist.size should equal(1)
      dashboard.accesslist.head.id_user should equal(106531)
    }
  }
}
