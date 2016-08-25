import scala.io.Source

object RoomRandomizer {
  def main(args: Array[String]) {
    val src = Source.fromFile("./data/rooms.csv")
    val iter = src.getLines().drop(1).map(_.split(","))
    iter foreach(a => println(a(0)))
  }
}
