class Thing(fields: Array[String], entry: Array[String]) {
  def get(field: String) = entry(fields indexOf field)
  override def toString() = get("Name") + " (" + get("Set") + ")"
}
