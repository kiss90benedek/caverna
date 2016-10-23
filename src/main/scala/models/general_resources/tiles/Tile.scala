package models.general_resources.tiles

trait SingleTile

case object Field extends SingleTile
case object Meadow extends SingleTile
case object SmallPasture extends SingleTile


trait TwinTile

case object FieldMeadow extends TwinTile
case object LargePasture extends TwinTile
