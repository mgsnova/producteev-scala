import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers

class RequestParametersSpec extends Spec with ShouldMatchers {
  describe("RequstParameters") {
    val reqParam = new RequestParameters("an_api_key", "an_api_secret")
    reqParam.add("k1", "v1")
    reqParam.add("a", "b")

    it("should save additional key value parameter pairs") {
      reqParam.add("key", "value")
    }

    it("should calc a raw parameter hash using all key value pairs ordered by key") {
      reqParam.signatureRaw should equal ("abapi_keyan_api_keyk1v1keyvaluean_api_secret")
    }

    it("should calc a signature out of the parameters") {
      reqParam.signature should equal ("f98898455b9a7d52e785c3c121298d04")
    }

    it("should calc a url parameter from the containing key value pairs") {
      reqParam.urlParameter should equal ("a=b&api_key=an_api_key&k1=v1&key=value&api_sig=f98898455b9a7d52e785c3c121298d04")    
    }
  }
}
