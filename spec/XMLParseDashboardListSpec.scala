import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

class XMLParseDashboardListSpec extends Spec with ShouldMatchers {
  describe("XMLParseDashboardList") {
    val xml_content = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <dashboards>
        <node>
          <dashboard>
            <id_dashboard>243972</id_dashboard>
            <id_creator>106531</id_creator>
            <title>privat</title>
            <write_ok>1</write_ok>
            <time_lastchange>Wed, 11 May 2011 21:06:39 +0200</time_lastchange>
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
        </node>
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
        </node>
      </dashboards>"""
    val xml_element = XML.loadString(xml_content)   

    it("should parse list of dashboard out of xml tree") {
      val dashboard_list = XMLParseDashboardList.parse(xml_element)
      dashboard_list.size should equal(2)

      dashboard_list.head.id_dashboard should equal(243972)
      dashboard_list.head.title should equal("privat")

      dashboard_list.last.id_dashboard should equal(250322)
      dashboard_list.last.title should equal("second")
    }
  }
}
