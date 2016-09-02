import scala.io.Source

object Sets extends Enumeration {
  type Sets = Value
  val Base = Value("Base")
  val Soloth = Value("Soloth")
  val Vermin = Value("Vermin")
}
import Sets._

class Thing(fields: Array[String], entry: Array[String]) {
  def get(field: String) = entry(fields indexOf field)
  override def toString() = get("Name")
}

object ThingFactory {
  def createThingMap(fields: Array[String], iter: Iterator[Array[String]]) : Map[Int, Thing] = {
    var things = Map[Int, Thing]()
    iter foreach(a => things = things + (a(0).toInt -> new Thing(fields, a)))

    return things
  }
}

object Collection {

  def getThings(file: String) : Map[Int, Thing] = {
    val src = Source.fromFile(file)
    val fields = src.getLines().take(1).map(_.split(",")).toArray
    // return ThingFactory.createThingMap(src.getLines().take(1).map(_.split(",")).toArray(),
    return ThingFactory.createThingMap(fields(0),
                                       src.getLines().drop(1).map(_.split(",")))
  }

  val Boards = getThings("./data/boards.csv")
  val Monsters = getThings("./data/monsters.csv")
  // val Lords = getThings("./data/lords.csv")
}
