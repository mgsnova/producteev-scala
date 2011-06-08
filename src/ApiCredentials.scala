import scala.io.Source

object ApiCredentials {
  def fromFiles(api_key_file: String, api_secret_file: String): ApiCredentials = {
    val api_key = Source.fromFile(api_key_file).mkString.stripLineEnd
    val api_secret = Source.fromFile(api_secret_file).mkString.stripLineEnd
    new ApiCredentials(api_key, api_secret)
  }
}

class ApiCredentials(api_key: String, api_secret: String) {
  def key: String = api_key
  def secret: String = api_secret
}
