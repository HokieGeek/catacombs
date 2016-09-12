object RoomType extends Enumeration {
  type RoomType = Value
  val Battle, Merchant, Healer = Value
}
import RoomType._

object Setup extends App {
  // def randomRoom(roomType: RoomType, level: String) : Map[String, String] = {
  //   Things.filter(Things.filter(Things.Rooms, "Type", roomType.toString), "Level", level)
  // }

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

    // Things.Rooms.filter((t) => t._2("Type") == "Special").foreach(a => Things.print(a._2))
    // Things.RoomFilter("Type", "Special").foreach(a => Things.print(a._2))
    // Things.Rooms.filter((t) => t._2("Level") == "0").foreach(a => Things.print(a._2))
    Things.filter(Things.Rooms, "Level", "0").foreach(a => Things.print(a._2))
    // randomRoom foreach println
    // Things.filter(Things.filter(Things.Rooms, "Type", Battle), "Level", 0) foreach println
  }

  Basic()
}
