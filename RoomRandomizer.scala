import scala.io.Source

object Sets extends Enumeration {
  type Sets = Value
  val Base = Value("Base")
}
import Sets._

class Board(_id: Integer, _set: Sets, _name: String, _numObstacles: Integer) {
  def id = _id
  def set = _set
  def name = _name
  def numObstacles = _numObstacles

  override def toString() =
    "[" + id + "] " + name + " / " + numObstacles + " (" + set + ")"
}

/*
class Lord() {
}

class Monster() {
}

class Room() {
}
*/

object RoomRandomizer {
  def getBoards = {
    val src = Source.fromFile("./data/boards.csv")
    val iter = src.getLines().drop(1).map(_.split(","))
    // iter foreach(a => println(a(0)+" "+a(2)))
    // TODO: figure out if reading header can be used to figure out the column needed
    // var Boards:Map[Int, Board] = Map()
    var Boards = Map[Int, Board]()
    // iter foreach(a => Boards + (a(0) -> new Board(a(0), a(1), a(2), a(3))))
    iter foreach(a => Boards + (a(0).toInt -> new Board(a(0).toInt, Base, a(2), a(3).toInt)))

    for(b <- Boards) println(b)
    Boards foreach(a => println(a))
    println ("TEST")
    println(Boards get 1)

    val Boards2 = Map(1 -> "Uno", 2 -> "Dos", 3 -> "Tres")
    println(Boards2 get 1)
  }

  def main(args: Array[String]) {
    getBoards
  }
}
