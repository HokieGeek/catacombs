import scala.io.Source

class Thing(fields: Array[String], entry: Array[String]) {
  def get(field: String) = entry(fields indexOf field)
  override def toString() = get("Name") + " (" + get("Set") + ")"
}

object ThingFactory {
  def createThingMap(fields: Array[String], iter: Iterator[Array[String]]) : Map[String, Thing] = {
    var things = Map[String, Thing]()
    for (a <- iter) {
      var thing = new Thing(fields, a)
      things = things + (thing.get("Name") -> thing)
    }
    // iter foreach(a => things = things + (a(0).toInt -> new Thing(fields, a)))

    return things
  }
}

object Collection {
  def getThings(file: String) : Map[String, Thing] = {
    val src = Source.fromFile(file)
    val fields = src.getLines().take(1).map(_.split('\t')).toArray
    return ThingFactory.createThingMap(fields(0), src.getLines().map(_.split('\t')))
  }

  val Boards = getThings("./data/boards.tsv")
  val Monsters = getThings("./data/monsters.tsv")
  val Lords = getThings("./data/lords.tsv")
  val Rooms = getThings("./data/rooms.tsv")
}
