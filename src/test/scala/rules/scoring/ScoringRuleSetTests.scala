package rules.scoring

import models.Types.ResourceMap
import models.general_resources.playing_pieces._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class ScoringRuleSetTests extends FlatSpec with Matchers with PropertyChecks {
  "Dogs" should "be worth 1 point each" in {
    val countGen = Gen.choose(0, Integer.MAX_VALUE)

    forAll (countGen) { (count: Int) =>
      val resourceMap: ResourceMap = Map(Dog -> count)

      DogScoringRule.score(resourceMap) should be (count)
    }
  }

  val farmAnimalScoring =
    Table(
      ("animal", "scoringRule"),
      (Sheep,    SheepScoringRule),
      (Donkey,   DonkeyScoringRule),
      (WildBoar, WildBoarScoringRule),
      (Cattle,   CattleScoringRule)
    )

  "Farm animals" should "be worth -2 points if missing" in {
    forAll (farmAnimalScoring) { (animal: Any, animalScoringRule: ScoringRule) =>
      val resourceMap: ResourceMap = Map(animal -> 0)

      animalScoringRule.score(resourceMap) should equal (-2)
    }
  }

  "Farm animals" should "be worth 1 point each if not missing" in {
    forAll (farmAnimalScoring) { (animal: Any, animalScoringRule: ScoringRule) =>
      val countGen = Gen.choose(1, Integer.MAX_VALUE)

      forAll (countGen) { (count: Int) =>
        val resourceMap: ResourceMap = Map(animal -> count)

        animalScoringRule.score(resourceMap) should equal (count)
      }
    }
  }
}
