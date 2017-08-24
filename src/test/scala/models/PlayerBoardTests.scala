package models

import models.LandType._
import models.MountainType._
import org.scalatest._
import org.scalatest.prop.PropertyChecks

class PlayerBoardTests extends FlatSpec with Matchers with PropertyChecks {

  "Board start position" should "have one free cavern" in {
    val playerBoard: BasicPlayerBoard = new BasicPlayerBoard

    playerBoard.toString should equal (
      """|↟↟↟|   |
        #|↟↟↟|   |
        #|↟↟↟|▢  |
        #|↟↟↟|x  |""".stripMargin('#')
    )
  }

  "Board" should "look nice" in {
    val playerBoard: BasicPlayerBoard = new TestPlayerBoard

    playerBoard.toString should equal (
      """|↟∩∩|▢ ╬|
        #|Ξ∪∪|+♦x|
        #| ⊂⊃|x♢♦|
        #|o Ξ|xxx|""".stripMargin('#')
    )
  }
}

class TestPlayerBoard extends BasicPlayerBoard {
  lands(0)(0) = Land(Forest)
  lands(0)(1) = Land(LargePastureU)
  lands(0)(2) = Land(LargePastureU)
  lands(1)(0) = Land(Field)
  lands(1)(1) = Land(LargePastureD)
  lands(1)(2) = Land(LargePastureD)
  lands(2)(0) = Land(Meadow)
  lands(2)(1) = Land(LargePastureL)
  lands(2)(2) = Land(LargePastureR)
  lands(3)(0) = Land(SmallPasture)
  lands(3)(1) = Land(Meadow)
  lands(3)(2) = Land(Field)

  mountains(0)(0) = Mountain(Cavern)
  mountains(0)(1) = Mountain(Empty)
  mountains(0)(2) = Mountain(Tunnel)
  mountains(1)(0) = Mountain(DeepTunnel)
  mountains(1)(1) = Mountain(OreMine)
  mountains(1)(2) = Mountain(Used)
  mountains(2)(0) = Mountain(Used)
  mountains(2)(1) = Mountain(RubyMine)
  mountains(2)(2) = Mountain(OreMine)
  mountains(3)(0) = Mountain(Used)
  mountains(3)(1) = Mountain(Used)
  mountains(3)(2) = Mountain(Used)
}
