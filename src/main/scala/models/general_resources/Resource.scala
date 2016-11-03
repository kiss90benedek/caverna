package models.general_resources

trait Resource

trait RawMaterial extends Resource
case object Wood extends RawMaterial
case object Stone extends RawMaterial
case object Ore extends RawMaterial

trait Seed extends Resource
case object Grain extends Seed
case object Vegetable extends Seed

abstract class Animal extends Resource
abstract class FarmAnimal extends Animal
case object Dog extends Animal
case object Sheep extends FarmAnimal
case object Donkey extends FarmAnimal
case object WildBoar extends FarmAnimal
case object Cattle extends FarmAnimal

case object GoldCoin extends Resource
case object Food extends Resource
case object Ruby extends Resource
