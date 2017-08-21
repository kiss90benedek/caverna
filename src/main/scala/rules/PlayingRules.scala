package rules

import rules.scoring.{BasicScoringRuleSet, ScoringRule}

case class PlayingRules(scoringRule: ScoringRule) {
  def this() = this(new BasicScoringRuleSet)
}
