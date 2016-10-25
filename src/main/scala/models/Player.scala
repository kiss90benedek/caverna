package models

import models.Types.ResourceMap
import models.player_resources.{Dwarf, DwarfWithoutWeapon}

import scala.collection.immutable.TreeSet

case class Player(playerBoard: PlayerBoard, dwarves: TreeSet[Dwarf], resourceMap: ResourceMap) {
  def this() = this(BasicPlayerBoard, TreeSet(DwarfWithoutWeapon(1), DwarfWithoutWeapon(2)), Map())
}
