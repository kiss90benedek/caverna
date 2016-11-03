package rules.scoring

import models.Player
import models.Types.Score
import models.general_resources._

trait ScoringRule {
  def score(player: Player): Score = 0
}

trait All1ScoringRule extends ScoringRule {
  val resource: Resource

  override def score(player: Player): Score = {
    player.resourceMap.getOrElse(resource, 0)
  }
}

object DogScoringRule extends All1ScoringRule {
  override val resource = Dog
}

trait FarmAnimalScoringRule extends ScoringRule {
  val farmAnimal: FarmAnimal

  override def score(player: Player): Score = {
    val farmAnimalCount = player.resourceMap.getOrElse(farmAnimal, 0)
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

object GrainScoringRule extends ScoringRule {
  override def score(player: Player): Score = {
    val grainCount = player.resourceMap.getOrElse(Grain, 0)
    (grainCount + 1) / 2
  }
}

object VegetableScoringRule extends All1ScoringRule {
  override val resource = Vegetable
}
