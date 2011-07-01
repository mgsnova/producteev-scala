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
        res.dashboardList
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

    it("should set users sort by") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.userView)

      expecting {
        call(mockApiConnect.get(
          "users/set_sort_by",
          "api_key=key&sort=1&token=sessiontoken&api_sig=7fd4b385264f6489881513386d88e620",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersSetSortBy("sessiontoken", 1)
        res.user
      }
    }

    it("should set users timezone") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.userView)

      expecting {
        call(mockApiConnect.get(
          "users/set_timezone",
          "api_key=key&timezone=Europe%2FBerlin&token=sessiontoken&api_sig=7457d5229dd8c2875f0dd52e7420c406",
          "xml"
        )).andReturn(response)
      }

      whenExecuting(mockApiConnect) {
        val res = producteev.usersSetTimezone("sessiontoken", "Europe/Berlin")
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

    it("should perform dashboards/delete request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.statsSuccess)

      expecting {
        call(mockApiConnect.get(
          "dashboards/delete",
          "api_key=key&id_dashboard=123&token=sessiontoken&api_sig=1d4dfef38132263c6c0d4c14a442f77f",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsDelete("sessiontoken", 123)
        res.resultSuccess
      }
    }

    it("should perform dashboards/set_title request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.dashboardView)

      expecting {
        call(mockApiConnect.get(
          "dashboards/set_title",
          "api_key=key&id_dashboard=123&title=yes&token=sessiontoken&api_sig=3c4ae8fb8b1d57c74b805ac73a686a07",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsSetTitle("sessiontoken", 123, "yes")
        res.dashboard
      }
    }

    it("should perform dashboards/set_smart_labels request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.dashboardView)

      expecting {
        call(mockApiConnect.get(
          "dashboards/set_smart_labels",
          "api_key=key&id_dashboard=123&token=sessiontoken&value=0&api_sig=cfc07f0f3bde6fc6313c08a735cc1e53",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.dashboardsSetSmartLabels("sessiontoken", 123, 0)
        res.dashboard
      }
    }

    it("should perform tasks/show_list request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskList)

      expecting {
        call(mockApiConnect.get(
          "tasks/show_list",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksShowlist("sessiontoken")
        res.taskList
      }
    }

    it("should perform tasks/show_list request with dashboard id") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskList)

      expecting {
        call(mockApiConnect.get(
          "tasks/show_list",
          "api_key=key&id_dashboard=42&token=sessiontoken&api_sig=b8cea9ad5c4b0fcf3672ab1540e009a5",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksShowlist("sessiontoken", 42)
        res.taskList
      }
    }

    it("should perform tasks/view request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/view",
          "api_key=key&id_task=666&token=sessiontoken&api_sig=53e2333e043d8bd30b76bcc15ca54e02",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksView("sessiontoken", 666)
        res.task
      }
    }

    it("should perform tasks/my_tasks request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskList)

      expecting {
        call(mockApiConnect.get(
          "tasks/my_tasks",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksMyTasks("sessiontoken")
        res.taskList
      }
    }

    it("should perform tasks/set_title request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_title",
          "api_key=key&id_task=23&title=doit&token=sessiontoken&api_sig=ad97a5d79ec959a4c28a1acc2f7584ec",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetTitle("sessiontoken", 23, "doit")
        res.task
      }
    }

    it("should perform tasks/set_status request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_status",
          "api_key=key&id_task=23&status=1&token=sessiontoken&api_sig=8651ea9f49103f5431d4a3379681eb8d",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetStatus("sessiontoken", 23, 1)
        res.task
      }
    }

    it("should perform tasks/set_star request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_star",
          "api_key=key&id_task=23&star=5&token=sessiontoken&api_sig=4299ad975d04884cd709cf04adc08950",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetStar("sessiontoken", 23, 5)
        res.task
      }
    }

    it("should perform tasks/set_deadline request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_deadline",
          "all_day=0&api_key=key&deadline=Fri%2C+23+Apr+2027+17%3A05%3A12+%2B0200&id_task=23&token=sessiontoken&api_sig=3a92f2748a7be94a252efb32d1c7a2b3",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetDeadline("sessiontoken", 23, "Fri, 23 Apr 2027 17:05:12 +0200")
        res.task
      }
    }

    it("should perform tasks/set_reminder request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_reminder",
          "api_key=key&id_task=23&reminder=6&token=sessiontoken&api_sig=d7d082dcda78a4bf26442bc0337311c0",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetReminder("sessiontoken", 23, 6)
        res.task
      }
    }

    it("should perform tasks/set_deadline request all day") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_deadline",
          "all_day=1&api_key=key&deadline=Fri%2C+23+Apr+2027+17%3A05%3A12+%2B0200&id_task=23&token=sessiontoken&api_sig=52ce3b2b0b88e9b72e5cea13fd4071d4",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetDeadline("sessiontoken", 23, "Fri, 23 Apr 2027 17:05:12 +0200", 1)
        res.task
      }
    }

    it("should perform tasks/unset_deadline request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/unset_deadline",
          "api_key=key&id_task=23&token=sessiontoken&api_sig=816f661c9b30fabdbb1eb3ad05968f66",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksUnsetDeadline("sessiontoken", 23)
        res.task
      }
    }

    it("should perform tasks/set_repeating request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/set_repeating",
          "api_key=key&id_task=123&repeating_interval=weeks&repeating_value=2&token=sessiontoken&api_sig=e531d69f66102aa40bed665d9ecf3460",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksSetRepeating("sessiontoken", 123, "weeks", 2)
        res.task
      }
    }

    it("should perform tasks/unset_repeating request") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/unset_repeating",
          "api_key=key&id_task=123&token=sessiontoken&api_sig=a9db8af1b65de6ea2ae6056d4a8c4f40",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksUnsetRepeating("sessiontoken", 123)
        res.task
      }
    }

    it("should perform tasks/create request with title") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/create",
          "api_key=key&title=wazzup&token=sessiontoken&api_sig=91cf56ad5ff8036e826f20f8ea5dfe57",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksCreateSimple("sessiontoken", "wazzup")
        res.task
      }
    }

    it("should perform tasks/create request with title, dashboard") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/create",
          "api_key=key&id_dashboard=432&title=wazzup&token=sessiontoken&api_sig=c39f48a93aeca772d80f489b850e53be",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksCreateSimple("sessiontoken", "wazzup", 432)
        res.task
      }
    }

    it("should perform tasks/delete") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.statsSuccess)

      expecting {
        call(mockApiConnect.get(
          "tasks/delete",
          "api_key=key&id_task=123&token=sessiontoken&api_sig=a9db8af1b65de6ea2ae6056d4a8c4f40",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksDelete("sessiontoken", 123)
        res.resultSuccess
      }
    }

    it("should perform tasks/change_labels") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/change_labels",
          "api_key=key&id_task=321&token=sessiontoken&id_label[]=1&id_label[]=42&api_sig=38a56413b3e85dd7e48edbd16cc9d744",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksChangeLabels("sessiontoken", 321, List(1, 42))
        res.task
      }
    }

    it("should perform tasks/change_labels emtpy") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskView)

      expecting {
        call(mockApiConnect.get(
          "tasks/change_labels",
          "api_key=key&id_task=321&token=sessiontoken&api_sig=38a56413b3e85dd7e48edbd16cc9d744",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksChangeLabels("sessiontoken", 321, List())
        res.task
      }
    }

    it("should perform tasks/note_create") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.noteView)

      expecting {
        call(mockApiConnect.get(
          "tasks/note_create",
          "api_key=key&id_task=321&message=noted&token=sessiontoken&api_sig=58a169863c8fa8d840deaeef602a2a2a",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksNoteCreate("sessiontoken", 321, "noted")
        res.note
      }
    }

    it("should perform tasks/note_delete") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.statsSuccess)

      expecting {
        call(mockApiConnect.get(
          "tasks/note_delete",
          "api_key=key&id_note=32123&token=sessiontoken&api_sig=253dcbb144cc441e65129e6874eed0f9",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.tasksNoteDelete("sessiontoken", 32123)
        res.resultSuccess
      }
    }

    it("should perform labels/show_list") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.labelList)

      expecting {
        call(mockApiConnect.get(
          "labels/show_list",
          "api_key=key&token=sessiontoken&api_sig=904395f8ee9255d14ad500ce4bcdc3c9",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsShowlist("sessiontoken")
        res.labelList
      }
    }

    it("should perform labels/view") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.labelView)

      expecting {
        call(mockApiConnect.get(
          "labels/view",
          "api_key=key&id_label=555&token=sessiontoken&api_sig=95fa37d0e95dca471f72198969817584",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsView("sessiontoken", 555)
        res.label
      }
    }

    it("should perform labels/create") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.labelView)

      expecting {
        call(mockApiConnect.get(
          "labels/create",
          "api_key=key&id_dashboard=321&title=foo&token=sessiontoken&api_sig=a7794e1461622ae91180c3f77a0a9bd6",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsCreate("sessiontoken", "foo", 321)
        res.label
      }
    }

    it("should perform labels/delete") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.statsSuccess)

      expecting {
        call(mockApiConnect.get(
          "labels/delete",
          "api_key=key&id_label=21&token=sessiontoken&api_sig=a58455bf95cb9afdfb71acd57a49fdc2",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsDelete("sessiontoken", 21)
        res.resultSuccess
      }
    }

    it("should perform labels/set_title") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.labelView)

      expecting {
        call(mockApiConnect.get(
          "labels/set_title",
          "api_key=key&id_label=21&title=tagged&token=sessiontoken&api_sig=df272138dde1766f5d70261c596dfc2a",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsSetTitle("sessiontoken", 21, "tagged")
        res.label
      }
    }

    it("should perform labels/tasks") {
      val mockApiConnect = mock[ApiConnect]
      val producteev = new Producteev(mockApiConnect, credentials, "xml")
      val response = new ApiResponse(200, TestXml.taskList)

      expecting {
        call(mockApiConnect.get(
          "labels/tasks",
          "api_key=key&id_label=55&token=sessiontoken&api_sig=ef799280bfc6b93bf1d54b5167a07ab1",
          "xml"
        )).andReturn(response)
      }
    
      whenExecuting(mockApiConnect) {
        val res = producteev.labelsTasks("sessiontoken", 55)
        res.taskList
      }
    }
  }
}
