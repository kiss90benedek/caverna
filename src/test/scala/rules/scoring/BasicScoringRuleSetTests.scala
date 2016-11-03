package rules.scoring

import models.Player
import models.Types.ResourceMap
import models.general_resources._
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class BasicScoringRuleSetTests extends FlatSpec with Matchers with PropertyChecks {
  val player: Player = new Player(1)

  "Total score" should "be sum of scores" in {
    val resourceMap: ResourceMap = Map(
      Dog -> 3,
      Sheep -> 5,
      Donkey -> 2,
      WildBoar -> 9,
      Cattle -> 1,
      Grain -> 6,
      Vegetable -> 7
    )

    BasicScoringRuleSet.score(player.apply(resourceMap)) should equal (30)
  }

  "Total score" should "be sum of scores even when score is negative" in {
    BasicScoringRuleSet.score(new Player(1)) should equal (-8)
  }
}
