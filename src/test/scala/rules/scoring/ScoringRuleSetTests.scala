package rules.scoring

import models.Types.ResourceMap
import models.general_resources.playing_pieces.{Dog, Sheep}
import org.scalatest._

import collection.mutable.Stack

class ScoringRuleSetTests extends FlatSpec with Matchers {
  "Dogs" should "be worth 1 point each" in {
    val resourceMap: ResourceMap = Map(Dog -> 3)

    DogScoringRule.score(resourceMap) should be (3)
  }

  "Sheep" should "be worth 1 point each" in {
    val resourceMap: ResourceMap = Map(Sheep -> 5)

    SheepScoringRule.score(resourceMap) should be (5)
  }
}
