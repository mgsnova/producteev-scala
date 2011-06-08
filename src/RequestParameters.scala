import scala.collection.mutable.HashMap

class RequestParameters(api_key: String, api_secret: String) {
  val map = new HashMap[String, String]
  map += "api_key" -> api_key
  
  def add(key: String, value: String) {
    map += key -> value
  }

  def signature(): String = {
    MD5.sum(signature_raw())
  }

  def signature_raw(): String = {
    map.toList.sortBy({_._1}).foldLeft("")((sum, pair) => sum + pair._1 + pair._2) + api_secret
  }

  def url_parameter(): String = {
    val keys = map.toList.sortBy({_._1}).map(pair => pair._1 + "=" + pair._2).reduceLeft(_ + "&" + _)
    keys + "&api_sig=" + signature
  }
}
