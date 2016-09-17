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
    r.getOrElse(scala.util.Random.shuffle(r.keys.toList).head, r.head._2)
  }

  def randomLord : Map[String, String] = {
    Things.Lords.getOrElse(scala.util.Random.shuffle(Things.Lords.keys.toList).head, Things.Lords.head._2)
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

    Things.print(randomRoom(Battle, level = 0))
    Things.print(randomRoom(Battle, level = 1))
    Things.print(randomRoom(Merchant))
    Things.print(randomRoom(Battle, level = 1))
    Things.print(randomRoom(Battle, level = 1))
    Things.print(randomRoom(Healer))
    Things.print(randomRoom(Battle, level = 2))

    Things.print(randomLord)
  }

  Basic()
}
