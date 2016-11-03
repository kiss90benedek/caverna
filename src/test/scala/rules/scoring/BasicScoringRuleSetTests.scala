package rules.scoring

import models.Types.ResourceMap
import models.general_resources._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class BasicScoringRuleSetTests extends FlatSpec with Matchers with PropertyChecks {
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

    BasicScoringRuleSet.score(resourceMap) should equal (30)
  }

  "Total score" should "be sum of scores even when score is negative" in {
    val resourceMap: ResourceMap = Map(
      Dog -> 0,
      Sheep -> 0,
      Donkey -> 0,
      WildBoar -> 0,
      Cattle -> 0,
      Grain -> 0,
      Vegetable -> 0
    )

    BasicScoringRuleSet.score(resourceMap) should equal (-8)
  }

  "Missing resources" should "count as zero" in {
    val resourceMap: ResourceMap = Map()

    BasicScoringRuleSet.score(resourceMap) should equal (-8)
  }
}
