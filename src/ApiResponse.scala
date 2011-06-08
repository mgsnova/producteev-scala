class ApiResponse(code: Int, content: String) {
  def code(): Int = code
  def content(): String = content
}
