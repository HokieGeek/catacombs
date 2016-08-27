import scala.io.Source

object Sets extends Enumeration {
  type Sets = Value
  val Base = Value("Base")
}
import Sets._

class Board(_name: String, _set: Sets, _numObstacles: Int) {
  def name = _name
  def set = _set
  def numObstacles = _numObstacles

  override def toString() = name + " / " + numObstacles + " (" + set + ")"
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

  def getBoards : collection.mutable.Map[Int, Board] = {
    val src = Source.fromFile("./data/boards.csv")
    val iter = src.getLines().drop(1).map(_.split(","))
    // TODO: figure out if reading header can be used to figure out the column needed

    val boards = collection.mutable.Map[Int, Board]()
    iter foreach(a => boards += (a(0).toInt -> new Board(_name = a(2), _set = Base, _numObstacles = a(0).toInt)))

    return boards
  }

  def main(args: Array[String]) {
    val Boards = getBoards

    // Boards foreach(a => println(a._2))

    println(Boards get 5)
  }
}
