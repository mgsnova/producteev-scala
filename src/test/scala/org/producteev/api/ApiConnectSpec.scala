package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.mock.EasyMockSugar
import org.easymock.EasyMock.{expect => expectCall, replay, verify, createMock}
import java.net.{HttpURLConnection, URL}
import javax.net.ssl.HttpsURLConnection;

import org.producteev.misc._

class ApiConnectSpec extends Spec with ShouldMatchers with EasyMockSugar {
  describe("ApiConnect") {
    it("should return response on successful http communication") {
      val mockURLCreator = mock[ApiURLCreator]
      val mockURLConnectionWrapper = mock[URLConnectionWrapper]
      val apiConnect = new ApiConnect(mockURLCreator)

      expecting {
        call(mockURLCreator.connection("url", "param", "xml")).andReturn(mockURLConnectionWrapper)
        call(mockURLConnectionWrapper.responseCode).andReturn(200)
        call(mockURLConnectionWrapper.input).andReturn("some xml")
      }

      whenExecuting(mockURLCreator, mockURLConnectionWrapper) {
        val res = apiConnect.get("url", "param", "xml")
        res.code should equal (200)
        res.content should equal ("some xml")
      }
    }

    it("should return response on non successful http communication") {
      val mockURLCreator = mock[ApiURLCreator]
      val mockURLConnectionWrapper = mock[URLConnectionWrapper]
      val apiConnect = new ApiConnect(mockURLCreator)
/* TODO make this working
      expecting {
        call(mockURLCreator.connection("url", "param", "xml")).andReturn(mockURLConnectionWrapper)
        call(mockURLConnectionWrapper.responseCode).andThrow(new java.io.IOException)
        call(mockURLConnectionWrapper.responseCode).andReturn(400)
        call(mockURLConnectionWrapper.inputString).andReturn("some error xml")
      }

      whenExecuting(mockURLCreator, mockURLConnectionWrapper) {
        val res = apiConnect.get("url", "param", "xml")
        res.code should equal (400)
        res.content should equal ("some error xml")
      }
*/
    }
  }
}
