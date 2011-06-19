package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class RequestParametersSpec extends Spec with ShouldMatchers {
  describe("RequstParameters") {
    val reqParam = new RequestParameters("an_api_key", "an_api_secret")
    reqParam.add("k1", "v1")
    reqParam.add("a", "b with space")

    it("should save additional key value parameter pairs") {
      reqParam.add("key", "value")
    }

    it("should calc a raw parameter hash using all key value pairs ordered by key") {
      reqParam.signatureRaw should equal ("ab with spaceapi_keyan_api_keyk1v1keyvaluean_api_secret")
    }

    it("should calc a signature out of the parameters") {
      reqParam.signature should equal ("182a9e3f94c8b28e36ace6a6946e371c")
    }

    it("should calc a url parameter from the containing key value pairs") {
      reqParam.urlParameter should equal ("a=b+with+space&api_key=an_api_key&k1=v1&key=value&api_sig=182a9e3f94c8b28e36ace6a6946e371c")
    }
  }
}
