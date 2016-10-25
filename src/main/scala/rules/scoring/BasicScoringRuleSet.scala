package rules.scoring
import models.Types.{ResourceMap, Score}

case object BasicScoringRuleSet extends ScoringRule {
  val rules: List[ScoringRule] = List(
    DogScoringRule, SheepScoringRule, DonkeyScoringRule, WildBoarScoringRule, CattleScoringRule,
    GrainScoringRule, VegetableScoringRule
  )

  override def score(resourceMap: ResourceMap): Score = {
    rules.map(rule => rule.score(resourceMap)).sum
  }
}
