package models.player_resources

import org.scalatest._

import scala.collection.immutable.TreeSet

class DwarfTests extends FlatSpec with Matchers {
  "Dwarfes" should "be ordered by weapon strength and then by birth order" in {
    val dwarfes: TreeSet[Dwarf] = TreeSet(
      DwarfWithWeapon(8, 2),
      DwarfWithoutWeapon(4),
      DwarfWithWeapon(3, 5),
      DwarfWithoutWeapon(3),
      DwarfWithWeapon(10, 1)
    )
    val expectedOrder = List(
      (0, 3),
      (0, 4),
      (3, 5),
      (8, 2),
      (10, 1)
    )

    dwarfes.toList.map(dwarf => (dwarf.weaponStrength, dwarf.birthOrder)) should equal (expectedOrder)
  }
}
