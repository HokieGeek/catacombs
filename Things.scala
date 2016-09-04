import scala.io.Source

object Things {
  def getThings(file: String) : Map[String, Map[String, String]] = {
    val src = Source.fromFile(file)
    val fields = src.getLines().take(1).map(_.split('\t')).next()

    var things = Map[String, Map[String, String]]()

    for (a <- src.getLines().map(_.split('\t'))) {
      val thing = fields.zip(a).toMap
      things = things + (thing(fields(0)) -> thing)
    }

    return things
  }

  def printRoom(thing: Map[String, String]) = {
    // Print name, set and board
    printf("%s [%s]", thing("Name"), thing("Set"))

    if (roomBoards contains thing("Name"))
      printf(" on %s", roomBoards(thing("Name"))("Board"))

    println()

    // Print monsters
    // TODO
  }

  val Boards = getThings("./data/boards.tsv")
  val Monsters = getThings("./data/monsters.tsv")
  val Lords = getThings("./data/lords.tsv")
  val Rooms = getThings("./data/rooms.tsv")

  val roomBoards = getThings("./data/rooms-boards.tsv")
  val roomMonsters = getThings("./data/rooms-monsters.tsv")

  // val lordBoards = getThings("./data/lords-boards.tsv")
  // val lordMonsters = getThings("./data/lords-monsters.tsv")
}
