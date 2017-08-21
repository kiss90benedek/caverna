package rules.scoring
import models.Player
import models.Types.Score

case class BasicScoringRuleSet(rules: List[ScoringRule]) extends ScoringRule {
  def this() = this(BasicScoringRuleSet.defaultRules)

  override def score(player: Player): Score = {
    rules.map(rule => rule.score(player)).sum
  }
}

case object BasicScoringRuleSet {
  val defaultRules: List[ScoringRule] = List(
    DogScoringRule, SheepScoringRule, DonkeyScoringRule, WildBoarScoringRule, CattleScoringRule,
    GrainScoringRule, VegetableScoringRule
  )
}
