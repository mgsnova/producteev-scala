package org.producteev

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.EasyMockSugar
import org.easymock.EasyMock.{expect => expectCall, replay, verify, createMock}

import org.producteev.api._

class ProducteevSpec extends Spec with ShouldMatchers with EasyMockSugar {
  describe("Producteev") {
    val credentials = new ApiCredentials("key", "secret")

    it("should perform time request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.time)

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
      val response = new ApiResponse(200, TestXml.userLogin)

      expecting {
        call(mockApiConnect.get(
          "users/login",
          "api_key=key&email=user&password=pass&api_sig=fd44757870fd844c153a3072de969f5d",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersLogin("user", "pass")
        res.token
        res.mail   
      }
    }

    it("should perform dashboards/showlist request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.dashboardList)

      expecting {
        call(mockApiConnect.get(
          "dashboards/show_list",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsShowlist("sessiontoken")
        res.dashboard_list
      }
    }

    it("should perform users/view request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.userView)

      expecting {
        call(mockApiConnect.get(
          "users/view",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersView("sessiontoken")
        res.user
      }
    }

    it("should perform users/view request with colleague id") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.userView)

      expecting {
        call(mockApiConnect.get(
          "users/view",
          "api_key=key&id_colleague=123&token=sessiontoken&api_sig=020f9e06903d196e82da6d590ffe9ad0",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersView("sessiontoken", 123)
        res.user
      }
    }

    it("should set users default dashboard") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.userView)

      expecting {
        call(mockApiConnect.get(
          "users/set_default_dashboard",
          "api_key=key&id_dashboard=123&token=sessiontoken&api_sig=1d4dfef38132263c6c0d4c14a442f77f",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersSetDefaultDashboard("sessiontoken", 123)
        res.user
      }
    }

    it("should perform dashboards/view request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.dashboardView)

      expecting {
        call(mockApiConnect.get(
          "dashboards/view",
          "api_key=key&id_dashboard=123&token=sessiontoken&api_sig=1d4dfef38132263c6c0d4c14a442f77f",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsView("sessiontoken", 123)
        res.dashboard
      }
    }

    it("should perform dashboards/create request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.dashboardView)

      expecting {
        call(mockApiConnect.get(
          "dashboards/create",
          "api_key=key&title=a_title&token=sessiontoken&api_sig=56fb32e682962f0d36ee8c95bc37b021",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsCreate("sessiontoken", "a_title")
        res.dashboard
      }
    }
  }
}
