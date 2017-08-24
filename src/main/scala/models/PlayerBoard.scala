package models

trait PlayerBoard

object LandType extends Enumeration {
  type LandType = Value
  val Forest = Value("↟")
  val Meadow = Value(" ")
  val Field = Value("Ξ")
  val SmallPasture = Value("o")
  val LargePastureL = Value("⊂")
  val LargePastureR = Value("⊃")
  val LargePastureU = Value("∩")
  val LargePastureD = Value("∪")
}

import LandType._

object MountainType extends Enumeration {
  type MountainType = Value
  val Empty = Value(" ")
  val Used = Value("x")
  val Cavern = Value("▢")
  val Tunnel = Value("╬")
  val DeepTunnel = Value("+")
  val OreMine = Value("♦")
  val RubyMine = Value("♢")
}

import MountainType._

trait Square
case class Land(surface: LandType) extends Square {
  override def toString: String = surface.toString
}
case class Mountain(surface: MountainType) extends Square {
  override def toString: String = surface.toString
}

case class BasicPlayerBoard(lands: Array[Array[Land]], mountains: Array[Array[Mountain]]) extends PlayerBoard {
  def this() = this(BasicPlayerBoard.startingLands, BasicPlayerBoard.startingMountains)

  override def toString: String = {
    ((lands.map(_.mkString) zip mountains.map(_.mkString)) map {case (l, m) => "|" + l + "|" + m + "|"}).mkString("\n")
  }
}

case object BasicPlayerBoard {
  val ROWS: Int = 4
  val COLUMNS: Int = 3

  val startingLands: Array[Array[Land]] = Array.fill[Land](ROWS, COLUMNS)(Land(Forest))
  val startingMountains: Array[Array[Mountain]] = {
    val sM = Array.fill[Mountain](ROWS, COLUMNS)(Mountain(Empty))
    sM(2)(0) = Mountain(Cavern)
    sM(3)(0) = Mountain(Used)
    sM
  }
}