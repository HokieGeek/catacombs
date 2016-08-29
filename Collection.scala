import scala.io.Source

object Sets extends Enumeration {
  type Sets = Value
  val Base = Value("Base")
  val Soloth = Value("Soloth")
  val Vermin = Value("Vermin")
}
import Sets._

class Thing(fields: Iterator[Array[String]], entry: Array[String]) {
  // def fieldId(name: String) = 
  // def get(field: String) = entry(fieldIds[field])
  def get(field: Int) = entry(field)

  // val fieldIds = Map[String, Int]

  // override def toString() = get("Name")
  override def toString() = get(0)
  // override def toString() = "blah"
}

object ThingFactory {
  def createThingMap(fields: Iterator[Array[String]], iter: Iterator[Array[String]]) : Map[Int, Thing] = {
    var things = Map[Int, Thing]()
    iter foreach(a => things = things + (a(0).toInt -> new Thing(fields, a)))

    return things
  }
}

class Board(entry: Array[String]) {
  def set = Sets.withName(entry(1))
  def name = entry(2)
  def numObstacles = entry(3)

  override def toString() = name
}

class Monster(entry: Array[String]) {
  // ID   Set   Name   Class   Health   Reward   Special Ability   Actions
  def set = Sets.withName(entry(1))
  def name = entry(2)
  def charClass = entry(3)
  def health = entry(4)
  def reward = entry(5)
  def special = entry(6)
  def actions = entry(7)

  override def toString() = name
}

class Lord(entry: Array[String]) {
  // Name   Set   Health   Board   Wanderer   Special Action   Minions
  def name = entry(0)

  override def toString() = name
}

/*
class Room() {
  // Name   Set   Type   Level   Board   N   E   S   W Monsters[]
}
*/

object Collection {

  def getThings(file: String) : Map[Int, Thing] = {
    val src = Source.fromFile(file)
    return ThingFactory.createThingMap(src.getLines().take(1).map(_.split(",")),
                                       src.getLines().drop(1).map(_.split(",")))
  }

  def getBoards(file: String) : Map[Int, Board] = {
    val src = Source.fromFile(file)
    val iter = src.getLines().drop(1).map(_.split(","))

    var things = Map[Int, Board]()
    iter foreach(a => things = things + (a(0).toInt -> new Board(a)))

    return things
  }

  def getMonsters(file: String) : Map[Int, Monster] = {
    val src = Source.fromFile(file)
    val iter = src.getLines().drop(1).map(_.split(","))

    var things = Map[Int, Monster]()
    iter foreach(a => things = things + (a(0).toInt -> new Monster(a)))

    return things
  }

  val Boards = getBoards("./data/boards.csv")
  val Monsters = getMonsters("./data/monsters.csv")
  val Things = getThings("./data/boards.csv")
}
