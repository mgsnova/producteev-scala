package org.producteev.xml

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import scala.xml._

import org.producteev.TestXml
import org.producteev.model.User

class XMLParseUserSpec extends Spec with ShouldMatchers {
  describe("XMLParseUser") {
    val xmlElementUserListItem = XML.loadString(TestXml.userListItem)   
    val xmlElementUser = XML.loadString(TestXml.userView)   

    def assertUser(user: User) {
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

    it("should parse xml tree (from list) to a user") {
      val user = XMLParseUser.parse(xmlElementUserListItem)
      assertUser(user)
      user.dashboard_status should equal (1)
    }

    it("should parse xml tree (from view) to a user") {
      val user = XMLParseUser.parse(xmlElementUser)
      assertUser(user)
      user.dashboard_status should equal (-1)
    }
  }
}
