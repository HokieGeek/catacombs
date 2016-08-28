import scala.io.Source

object Sets extends Enumeration {
  type Sets = Value
  val Base = Value("Base")
  val Soloth = Value("Soloth")
  val Vermin = Value("Vermin")
}
import Sets._

// class Thing2[T] {
//   def create(implicit m: ClassManifest[T]) = m.erasure.create
// }

class Thing { }

class Board(entry: Array[String]) extends Thing {
  def set = Sets.withName(entry(1))
  def name = entry(2)
  def numObstacles = entry(3)

  override def toString() = name + " / " + numObstacles + " (" + set + ")"
}

class Monster(entry: Array[String]) extends Thing {
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

/*
class Lord() {
  // Name   Set   Health   Board   Wanderer   Special Action   Minions
}

class Room() {
  // Name   Set   Type   Level   Board   N   E   S   W Monsters[]
}
*/

object Collection {

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
}
