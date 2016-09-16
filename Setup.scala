object RoomType extends Enumeration {
  type RoomType = Value
  val Battle, Merchant, Healer = Value
}
import RoomType._

object Setup extends App {
  def roomsByType(roomType: RoomType, level: Int = -1) : Map[String, Map[String, String]] = {
    roomType match {
      case Battle => Things.filter(Things.filter(Things.Rooms, "Type", "Battle"), "Level", level.toString)
      case special => Things.filter(Things.filter(Things.Rooms, "Type", "Special"), "Name", special.toString)
    }
  }

  def randomRoom(roomType: RoomType, level: Int = -1) : Map[String, String] = {
    val r = roomsByType(roomType, level)
    // println(scala.util.Random.shuffle(r.keys))
    // println(scala.util.Random.shuffle(r.keys).head)
    r.getOrElse(scala.util.Random.shuffle(r.keys).head, r.head._2)
  }

  def Basic() {
    /*
     * Basic setup
     * 1. Level 0 card
     * 2. Level 1 card
     * 3. Merchant
     * 4. Level 1 card
     * 5. Level 1 card
     * 6. Healer
     * 7. Level 2 card
     * 8. Catacomb Lord
     */

    // TODO: ensure no dupes

    println("Level 0 Room: ")
    Things.print(randomRoom(Battle, level = 0))

    println("Healer: ")
    Things.print(randomRoom(Healer))
  }

  Basic()
}
