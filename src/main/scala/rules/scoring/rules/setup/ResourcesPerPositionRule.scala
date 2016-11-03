package rules.scoring.rules.setup

import models.Types.ResourceMap
import models.general_resources.playing_pieces.Food

object ResourcesPerPositionRule {
  private val resourceMap: Map[Int, ResourceMap] = Map(
    1 -> Map(Food -> 1),
    2 -> Map(Food -> 1),
    3 -> Map(Food -> 2),
    4 -> Map(Food -> 3),
    5 -> Map(Food -> 3),
    6 -> Map(Food -> 3),
    7 -> Map(Food -> 3)
  )

  def getResources(startingPosition: Int): ResourceMap = {
    resourceMap.getOrElse(startingPosition, throw new IllegalArgumentException(s"Illegal starting position: $startingPosition"))
  }
}
