package rules.scoring

import models.Types.{ResourceMap, Score}
import models.general_resources.playing_pieces._

trait ScoringRule {
  def score(resourceMap: ResourceMap): Score = 0
}

object DogScoringRule extends ScoringRule {
  override def score(resourceMap: ResourceMap): Score = {
    resourceMap.getOrElse(Dog, 0)
  }
}

trait FarmAnimalScoringRule extends ScoringRule {
  val farmAnimal: FarmAnimal

  override def score(resourceMap: ResourceMap): Score = {
    val farmAnimalCount = resourceMap.getOrElse(farmAnimal, 0)
    if (farmAnimalCount == 0) -2 else farmAnimalCount
  }
}

object SheepScoringRule extends FarmAnimalScoringRule {
  override val farmAnimal = Sheep
}

object DonkeyScoringRule extends FarmAnimalScoringRule {
  override val farmAnimal = Donkey
}

object WildBoarScoringRule extends FarmAnimalScoringRule {
  override val farmAnimal = WildBoar
}

object CattleScoringRule extends FarmAnimalScoringRule {
  override val farmAnimal = Cattle
}
