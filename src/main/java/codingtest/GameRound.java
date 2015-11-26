package codingtest;

import codingtest.domain.Player;
import codingtest.domain.RuleResult;

public class GameRound {
	
	public static RuleResult play(Player player) {
		int sum = player.getCardsSum();
		if (sum < 17) {
			return RuleResult.HIT; 
		} 
		else if (sum >= 17 && sum < 21) {
			return RuleResult.STICK;
		}
		else if (sum == 21){
			return RuleResult.WIN;
		} else {
			return RuleResult.GO_BUST;
		}
	}
}
