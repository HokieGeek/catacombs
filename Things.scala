import scala.io.Source

object Things {
  def createThingMap(fields: Array[String], iter: Iterator[Array[String]]) : Map[String, Map[String, String]] = {
    var things = Map[String, Map[String, String]]()

    for (a <- iter) {
      var thing = fields.zip(a).toMap
      things = things + (thing("Name") -> thing)
    }

    return things
  }

  def getThings(file: String) : Map[String, Map[String, String]] = {
    val src = Source.fromFile(file)
    val fields = src.getLines().take(1).map(_.split('\t')).toArray
    return createThingMap(fields(0), src.getLines().map(_.split('\t')))
  }

  // def printRoom(thing: Thing) = {
  //   // Print name, set and board
  //   println(thing.get("Name"))

  //   // Print monsters
  // }

  val Boards = getThings("./data/boards.tsv")
  // val Monsters = getThings("./data/monsters.tsv")
  // val Lords = getThings("./data/lords.tsv")
  // val Rooms = getThings("./data/rooms.tsv")

  // val roomBoards = getThings("./data/rooms-boards.tsv")
  // val roomMonsters = getThings("./data/rooms-monsters.tsv")

  // val lordBoards = getThings("./data/lords-boards.tsv")
  // val lordMonsters = getThings("./data/lords-monsters.tsv")
}
