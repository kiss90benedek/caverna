package models

import models.Types.ResourceMap
import models.general_resources._
import org.scalatest.{FlatSpec, Matchers}

class PlayerTests extends FlatSpec with Matchers {
  "Players" should "be immutable and provide a new player when changing resources" in {
    val originalPlayer = new Player(1)
    val addedResources: ResourceMap = Map(
      Wood -> 1,
      Grain -> 2,
      Dog -> 3,
      Cattle -> 4,
      GoldCoin -> 5,
      Food -> 6,
      Ruby -> 7
    )

    val playerWithSomeMoreResources = originalPlayer.apply(addedResources)

    originalPlayer should equal(new Player(1))
    playerWithSomeMoreResources.resourceMap(Wood)     should equal(1 + originalPlayer.resourceMap.getOrElse(Wood, 0))
    playerWithSomeMoreResources.resourceMap(Grain)    should equal(2 + originalPlayer.resourceMap.getOrElse(Grain, 0))
    playerWithSomeMoreResources.resourceMap(Dog)      should equal(3 + originalPlayer.resourceMap.getOrElse(Dog, 0))
    playerWithSomeMoreResources.resourceMap(Cattle)   should equal(4 + originalPlayer.resourceMap.getOrElse(Cattle, 0))
    playerWithSomeMoreResources.resourceMap(GoldCoin) should equal(5 + originalPlayer.resourceMap.getOrElse(GoldCoin, 0))
    playerWithSomeMoreResources.resourceMap(Food)     should equal(6 + originalPlayer.resourceMap.getOrElse(Food, 0))
    playerWithSomeMoreResources.resourceMap(Ruby)     should equal(7 + originalPlayer.resourceMap.getOrElse(Ruby, 0))
  }
}
