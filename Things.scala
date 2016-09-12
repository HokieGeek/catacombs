import scala.io.Source

object Things {
  def loadFile(file:String) : (Array[String], Iterator[Array[String]]) = {
    val iter = Source.fromFile(file).getLines().map(_.split('\t'))
    return (iter.next(), iter)
  }

  def getThings(file: String) : Map[String, Map[String, String]] = {
    val (fields, iter) = loadFile(file)

    // iter foldLeft(Map[String, Map[String, String]]()) ((t, a) => t + (a(fields indexOf "Name") -> fields.zip(a).toMap))
    var things = Map[String, Map[String, String]]()
    iter foreach(a => things = things + (a(fields indexOf "Name") -> fields.zip(a).toMap))
    return things
  }

  def getRelationships(file: String) : Map[String, List[String]] = {
    val (fields, iter) = loadFile(file)

    var m = Map[String, List[String]]()

    // Imperative solution
    for (a <- iter) {
      if (m contains a(0)) {
        m = (m - a(0)) + (a(0) -> (m(a(0)) ::: List(a(1))))
      } else {
        m = m + (a(0) -> List(a(1)))
      }
    }

    return m
  }

  def print(thing: Map[String, String]) = {
    // Print name, set and board
    printf("%s [%s, %s, %s]", thing("Name"), thing("Level"), thing("Type"), thing("Set"))

    if (RoomBoards contains thing("Name"))
      printf(" on %s", RoomBoards(thing("Name")).head)
    println()

    // Print monsters
    RoomMonsters getOrElse (thing("Name"), Nil) foreach(a => printf("   %s\n", a))
  }

  // ... just because I can... ?
  val filter = (t: Map[String, Map[String, String]], f: String, v: String) => t.filter((a) => a._2(f) == v)
  // def filter(things: Map[String, Map[String, String]], field: String, value: Any) : Map[String, Map[String, String]] = {
  //   things.filter((t) => t._2(field) == value)
  // }

  val Boards   = getThings("data/boards.tsv")
  val Monsters = getThings("data/monsters.tsv")
  val Lords    = getThings("data/lords.tsv")
  val Rooms    = getThings("data/rooms.tsv")

  val RoomBoards   = getRelationships("data/rooms-boards.tsv")
  val RoomMonsters = getRelationships("data/rooms-monsters.tsv")
  val LordBoards   = getRelationships("data/lords-boards.tsv")
  val LordMonsters = getRelationships("data/lords-monsters.tsv")
}
