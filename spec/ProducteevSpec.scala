import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.EasyMockSugar
import org.easymock.EasyMock.{expect => expectCall, replay, verify, createMock}

class ProducteevSpec extends Spec with ShouldMatchers with EasyMockSugar {
  describe("Producteev") {
    val credentials = new ApiCredentials("key", "secret")
    val xml_result_time = """<?xml version="1.0" encoding="ISO-8859-1"?>
      <time>
        <value>Mon, 23 May 2011 16:22:41 -0400</value>
      </time>"""
    val xml_result_users_login = """<login>
       <token>a_session_token</token>
       <email>user@provider.com</email>
     </login>"""
    val xml_result_dashboards_showlist = """<?xml version="1.0" encoding="ISO-8859-1"?>
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
    val xml_result_users_view = """<?xml version="1.0" encoding="ISO-8859-1"?>
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

    it("should perform time request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_time)

      expecting {
        call(mockApiConnect.get(
          "time",
          "api_key=key&api_sig=cc60c9cf30454ae782f04c64766e1aac",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.time
        res.time
      }
    }

    it("should perform users/login request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_users_login)

      expecting {
        call(mockApiConnect.get(
          "users/login",
          "api_key=key&email=user&password=pass&api_sig=fd44757870fd844c153a3072de969f5d",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.users_login("user", "pass")
        res.token
        res.mail   
      }
    }

    it("should perform dashboards/showlist request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_dashboards_showlist)

      expecting {
        call(mockApiConnect.get(
          "dashboards/show_list",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.dashboards_showlist("sessiontoken")
        res.dashboard_list
      }
    }

    it("should perform users/view request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_users_view)

      expecting {
        call(mockApiConnect.get(
          "users/view",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.users_view("sessiontoken")
        res.user
      }
    }

    it("should perform users/view request with colleague id") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_users_view)

      expecting {
        call(mockApiConnect.get(
          "users/view",
          "api_key=key&id_colleague=123&token=sessiontoken&api_sig=020f9e06903d196e82da6d590ffe9ad0",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.users_view("sessiontoken", 123)
        res.user
      }
    }

    it("should set users default dashboard") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, xml_result_users_view)

      expecting {
        call(mockApiConnect.get(
          "users/set_default_dashboard",
          "api_key=key&id_dashboard=123&token=sessiontoken&api_sig=1d4dfef38132263c6c0d4c14a442f77f",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.users_set_default_dashboard("sessiontoken", 123)
        res.user
      }
    }
  }
}
