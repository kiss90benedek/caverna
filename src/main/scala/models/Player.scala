package models

import models.Types.ResourceMap
import models.player_resources.{Dwarf, DwarfWithoutWeapon}
import rules.scoring.rules.setup.ResourcesPerPositionRule

import scala.collection.immutable.TreeSet

case class Player(playerBoard: PlayerBoard, dwarves: TreeSet[Dwarf], resourceMap: ResourceMap) {
  require(2 <= dwarves.size && dwarves.size <= 6, s"Not enough or too many dwarf: ${dwarves.size}")

  def this(startingPosition: Int) =
    this(
      BasicPlayerBoard(),
      TreeSet(DwarfWithoutWeapon(1), DwarfWithoutWeapon(2)),
      ResourcesPerPositionRule.getResources(startingPosition)
    )
}
