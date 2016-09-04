import scala.io.Source

object Things {
  // def loadFile(file:String) : (Array[String], Iterator[Array[String]]) = {
  //   val iter = Source.fromFile(file).getLines().map(_.split('\t'))
  //   return (iter.next(), iter)
  // }

  def getThings(file: String) : Map[String, Map[String, String]] = {
    // val (fields, iter) = loadFile(file)
    val iter = Source.fromFile(file).getLines().map(_.split('\t'))
    val fields = iter.next()

    var things = Map[String, Map[String, String]]()
    iter foreach(a => things = things + (a(fields indexOf "Name") -> fields.zip(a).toMap))
    return things
  }

  def getRelationships(file: String) : Map[String, List[String]] = {
    // val (fields, iter) = loadFile(file)
    val iter = Source.fromFile(file).getLines().map(_.split('\t'))
    val fields = iter.next()

    var m = Map[String, List[String]]()

    iter foreach(r => r.map(a =>(a(0).toString, a(1).toString))
      .groupBy(_._1).mapValues(_.map(_._2)))

    // for (a <- iter) {
    //   m = m + (a(0) -> m(a(0)) ++ a(1))
    //   // m = m + (a(0) -> List())
    // }

    return m
  }

  def printRoom(thing: Map[String, String]) = {
    // Print name, set and board
    printf("%s [%s]", thing("Name"), thing("Set"))

    // if (roomBoards contains thing("Name"))
    //   printf(" on %s", roomBoards(thing("Name"))("Board"))

    println()

    // Print monsters
    // TODO
  }

  val Boards = getThings("./data/boards.tsv")
  val Monsters = getThings("./data/monsters.tsv")
  val Lords = getThings("./data/lords.tsv")
  val Rooms = getThings("./data/rooms.tsv")

  val roomBoards = getRelationships("./data/rooms-boards.tsv")
  // val roomMonsters = getRelationships("./data/rooms-monsters.tsv")

  // val lordBoards = getThings("./data/lords-boards.tsv")
  // val lordMonsters = getThings("./data/lords-monsters.tsv")
}
