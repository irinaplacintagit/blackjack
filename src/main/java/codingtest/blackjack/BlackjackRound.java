package codingtest.blackjack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import codingtest.domain.Player;
import codingtest.domain.BlackjackRule;

/**
 * @author Irina
 * 
 * Blackjack rules depending on the sum of the player's cards
 */
public class BlackjackRound {
	private static final Logger logger = LogManager.getLogger(BlackjackRound.class);
	
	public static BlackjackRule play(Player player) {
		int sum = player.getCardsSum();
		logger.info(player.getName() + " has a total of " + sum);
		if (sum < 17) {
			return BlackjackRule.HIT; 
		} 
		else if (sum >= 17 && sum < 21) {
			return BlackjackRule.STICK;
		}
		else if (sum == 21){
			return BlackjackRule.WIN;
		} else {
			return BlackjackRule.GO_BUST;
		}
	}
}
