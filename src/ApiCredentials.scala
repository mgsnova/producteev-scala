import scala.io.Source

object ApiCredentials {
  def fromFiles(apiKeyFile: String, apiSecretFile: String): ApiCredentials = {
    val apiKey = Source.fromFile(apiKeyFile).mkString.stripLineEnd
    val apiSecret = Source.fromFile(apiSecretFile).mkString.stripLineEnd
    new ApiCredentials(apiKey, apiSecret)
  }
}

class ApiCredentials(apiKey: String, apiSecret: String) {
  def key: String = apiKey
  def secret: String = apiSecret
}
