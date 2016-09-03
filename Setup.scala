/*
 * Basic setup
 * 1. Level 0 card
 * 2. Level 1 card
 * 3. Merchant
 * 4. Level 1 card
 * 5. Level 1 card
 * 6. Healer
 * 7. Level 2 card
 * 8. Catacbom Lord
 */

object Setup {
  def main(args: Array[String]) {

    // println("[BOARDS]")
    // Collection.Boards.foreach(a => println(a._2))
    // println("[MONSTERS]")
    // Collection.Monsters.foreach(a => println(a._2))
    // println("[LORDS]")
    // Collection.Lords.foreach(a => println(a._2))
    println("[ROOMS]")
    Things.Rooms.foreach(a => Things.printRoom(a._2))
    // Collection.Rooms.foreach(a => println(a._2))
  }
}
