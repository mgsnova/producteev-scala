import java.security.MessageDigest

object MD5 {
  def sum(string: String) : String = {
    val md5 = MessageDigest.getInstance("MD5")
    md5.reset()
    md5.update(string.getBytes("UTF-8"))
    md5.digest().map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
  }
}
