package rules.scoring

import models.Player
import models.Types.ResourceMap
import models.general_resources._
import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class ScoringRuleSetTests extends FlatSpec with Matchers with PropertyChecks {
  val player: Player = new Player(1)

  "Dogs" should "be worth 1 point each" in {
    val countGen = Gen.choose(0, Integer.MAX_VALUE)

    forAll (countGen) { (count: Int) =>
      val resourceMap: ResourceMap = Map(Dog -> count)

      DogScoringRule.score(player.apply(resourceMap)) should be (count)
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
    forAll (farmAnimalScoring) { (animal: Animal, animalScoringRule: ScoringRule) =>
      val resourceMap: ResourceMap = Map(animal -> 0)

      animalScoringRule.score(player.apply(resourceMap)) should equal (-2)
    }
  }

  "Farm animals" should "be worth 1 point each if not missing" in {
    forAll (farmAnimalScoring) { (animal: Animal, animalScoringRule: ScoringRule) =>
      val countGen = Gen.choose(1, Integer.MAX_VALUE)

      forAll (countGen) { (count: Int) =>
        val resourceMap: ResourceMap = Map(animal -> count)

        animalScoringRule.score(player.apply(resourceMap)) should equal (count)
      }
    }
  }

  val grainScoring =
    Table(
      ("count", "score"),
      (0,       0),
      (1,       1),
      (2,       1),
      (3,       2),
      (4,       2),
      (5,       3)
    )

  "Grains" should "be worth 1 point per 2, rounded up" in {
    forAll (grainScoring) { (count: Int, score: Int) =>
      val resourceMap: ResourceMap = Map(Grain -> count)

      GrainScoringRule.score(player.apply(resourceMap)) should equal (score)
    }
  }

  "Vegetables" should "be worth 1 point each" in {
    val countGen = Gen.choose(0, Integer.MAX_VALUE)

    forAll (countGen) { (count: Int) =>
      val resourceMap: ResourceMap = Map(Vegetable -> count)

      VegetableScoringRule.score(player.apply(resourceMap)) should be (count)
    }
  }
}
