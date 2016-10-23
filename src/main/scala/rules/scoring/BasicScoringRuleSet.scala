package rules.scoring
import models.Types.ResourceMap
import models.general_resources.playing_pieces.{Dog, Sheep}

case object BasicScoringRuleSet {
  val rules: List[ScoringRule] = List(DogScoringRule)
}
