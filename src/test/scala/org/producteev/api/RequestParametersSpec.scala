package org.producteev.api

import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class RequestParametersSpec extends Spec with ShouldMatchers {
  describe("RequstParameters") {
    def createParam() = {
      val reqParam = new RequestParameters("an_api_key", "an_api_secret")
      reqParam.add("k1", "v1")
      reqParam.add("a", "b with space")
      reqParam
    }

    it("should save additional key value parameter pairs") {
      val reqParam = createParam
      reqParam.add("key", "value")
    }

    it("should calc a raw parameter hash using all key value pairs ordered by key") {
      val reqParam = createParam
      reqParam.signatureRaw should equal ("ab with spaceapi_keyan_api_keyk1v1an_api_secret")
    }

    it("should calc a signature out of the parameters") {
      val reqParam = createParam
      reqParam.signature should equal ("fa2c8f5276947b5f63f297207de4d0e1")
    }

    it("should calc a url parameter from the containing key value pairs") {
      val reqParam = createParam
      reqParam.urlParameter should equal ("a=b+with+space&api_key=an_api_key&k1=v1&api_sig=fa2c8f5276947b5f63f297207de4d0e1")
    }

    it("should not use array parameters for signature") {
      val reqParam = createParam
      reqParam.add("foo[]", "bar")
      reqParam.signature should equal ("fa2c8f5276947b5f63f297207de4d0e1")
    }

    it("should use array parameters for parameter") {
      val reqParam = createParam
      reqParam.add("foo[]", "bar")
      reqParam.add("foo[]", "zomg")
      reqParam.urlParameter should equal ("a=b+with+space&api_key=an_api_key&k1=v1&foo[]=bar&foo[]=zomg&api_sig=fa2c8f5276947b5f63f297207de4d0e1")
    }
  }
}
