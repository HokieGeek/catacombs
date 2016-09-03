object RoomRandomizer {
  def main(args: Array[String]) {

    println("[BOARDS]")
    Collection.Boards.foreach(a => println(a._2))
    println("[MONSTERS]")
    Collection.Monsters.foreach(a => println(a._2))
    println("[LORDS]")
    Collection.Lords.foreach(a => println(a._2))
    println("[ROOMS]")
    Collection.Rooms.foreach(a => println(a._2))
  }
}
