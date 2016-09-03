import scala.io.Source

object Things {
  def createThingMap(fields: Array[String], iter: Iterator[Array[String]]) : Map[String, Thing] = {
    var things = Map[String, Thing]()
    for (a <- iter) {
      var thing = new Thing(fields, a)
      things = things + (thing.get("Name") -> thing)
    }
    // iter foreach(a => things = things + (a(0).toInt -> new Thing(fields, a)))

    return things
  }

  def getThings(file: String) : Map[String, Thing] = {
    val src = Source.fromFile(file)
    val fields = src.getLines().take(1).map(_.split('\t')).toArray
    return createThingMap(fields(0), src.getLines().map(_.split('\t')))
  }

  def printRoom(thing: Thing) = {
    println(thing)
  }

  val Boards = getThings("./data/boards.tsv")
  val Monsters = getThings("./data/monsters.tsv")
  val Lords = getThings("./data/lords.tsv")
  val Rooms = getThings("./data/rooms.tsv")

  // val roomBoards = getThings("./data/rooms-boards.tsv")
  // val roomMonsters = getThings("./data/rooms-monsters.tsv")
}
