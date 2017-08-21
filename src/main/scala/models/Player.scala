package models

import models.Types.ResourceMap
import models.player_resources.{Dwarf, DwarfWithoutWeapon}
import rules.PlayingRules
import rules.setup.ResourcesPerPositionRule

import scala.collection.immutable.{SortedSet, TreeSet}
import scalaz.Scalaz._

case class Player(playerBoard: PlayerBoard, dwarves: SortedSet[Dwarf], resourceMap: ResourceMap, playingRules: PlayingRules) {
  require(2 <= dwarves.size && dwarves.size <= 6, s"Not enough or too many dwarf: ${dwarves.size}")

  def this(startingPosition: Int) =
    this(
      BasicPlayerBoard(),
      TreeSet(DwarfWithoutWeapon(1), DwarfWithoutWeapon(2)),
      ResourcesPerPositionRule.getResources(startingPosition),
      new PlayingRules
    )

  def apply(resourceMap: ResourceMap): Player = {
    Player(
      playerBoard,
      dwarves,
      this.resourceMap |+| resourceMap,
      playingRules
    )
  }
}
