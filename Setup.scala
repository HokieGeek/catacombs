object RoomType extends Enumeration {
  type RoomType = Value
  val Battle, Merchant, Healer = Value
}
import RoomType._

object Setup extends App {
  // def randomRoom(roomType: RoomType, level: Int = -1) : Map[String, String] = {
  def randomRoom(roomType: RoomType, level: Int = -1) : Map[String, Map[String, String]] = {
    roomType match {
      case Battle => Things.filter(Things.filter(Things.Rooms, "Type", "Battle"), "Level", level.toString)
      case Healer => Things.filter(Things.filter(Things.Rooms, "Type", "Special"), "Name", roomType.toString)
      case Merchant => Things.filter(Things.filter(Things.Rooms, "Type", "Special"), "Name", roomType.toString)
    }
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

    // scala.util.Random.nextInt(NUM)

    println("Level 0 Rooms: ")
    randomRoom(Battle, level = 0).foreach(a => Things.print(a._2))

    println("Healers: ")
    randomRoom(Healer).foreach(a => Things.print(a._2))
  }

  Basic()
}
