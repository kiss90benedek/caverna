package models.player_resources

abstract class Dwarf(weaponStrength: Int)

case object DwarfWithoutWeapon extends Dwarf(0) {

}

case class DwarfWithWeapon(weaponStrength: Int) extends Dwarf(weaponStrength) {

}
