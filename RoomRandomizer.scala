object RoomRandomizer {
  def main(args: Array[String]) {

    println("[BOARDS]")
    Collection.Boards.foreach(a => println(a))
    println("[MONSTERS]")
    Collection.Monsters.foreach(a => println(a))
    // println("[LORDS]")
    // Collection.Lords.foreach(a => println(a))
  }
}
