package models.player_resources

abstract class Dwarf(val weaponStrength: Int, val birthOrder: Int) extends Ordered[Dwarf] {
  override def compare(that: Dwarf): Int = {
    import scala.math.Ordered.orderingToOrdered
    (this.weaponStrength, this.birthOrder) compare (that.weaponStrength, that.birthOrder)
  }
}

case class DwarfWithoutWeapon(override val birthOrder: Int)
  extends Dwarf(weaponStrength = 0, birthOrder = birthOrder) {

}

case class DwarfWithWeapon(override val weaponStrength: Int, override val birthOrder: Int)
  extends Dwarf(weaponStrength = weaponStrength, birthOrder = birthOrder) {

}
