class Dashboard(
  val id_dashboard: Integer,
  val id_creator: Integer,
  val title: String,
  val write_ok: Integer,
  val time_lastchange: String,
  val status: Integer,
  val deleted: Integer,
  val smart_labels: Integer,
  val needs_upgrade: Integer,
  val accesslist: List[User]
)
