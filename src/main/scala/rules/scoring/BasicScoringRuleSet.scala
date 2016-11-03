package rules.scoring
import models.Player
import models.Types.Score

case object BasicScoringRuleSet extends ScoringRule {
  val rules: List[ScoringRule] = List(
    DogScoringRule, SheepScoringRule, DonkeyScoringRule, WildBoarScoringRule, CattleScoringRule,
    GrainScoringRule, VegetableScoringRule
  )

  override def score(player: Player): Score = {
    rules.map(rule => rule.score(player)).sum
  }
}
