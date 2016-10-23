package models.general_resources.playing_pieces

abstract class Animal
abstract class FarmAnimal extends Animal

case object Dog extends Animal
case object Sheep extends FarmAnimal
case object Donkey extends FarmAnimal
case object WildBoar extends FarmAnimal
case object Cattle extends FarmAnimal
