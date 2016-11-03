package models.player_resources

import org.scalatest._

import scala.collection.immutable.{SortedSet, TreeSet}

class DwarfTests extends FlatSpec with Matchers {
  "Dwarfs" should "be ordered by weapon strength and then by birth order" in {
    val dwarfs: SortedSet[Dwarf] = TreeSet(
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

    dwarfs.toList.map(dwarf => (dwarf.weaponStrength, dwarf.birthOrder)) should equal (expectedOrder)
  }
}
