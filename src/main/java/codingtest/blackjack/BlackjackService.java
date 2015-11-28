package codingtest.blackjack;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import codingtest.domain.BlackjackRule;
import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.game.GameService;

/**
 * @author Irina
 *
 * Blackjack service that play rounds and play game E2E
 */
@Service
public class BlackjackService extends GameService {
	private static final Logger logger = LogManager.getLogger(BlackjackService.class);

	
	/**
	 * Give 2 cards to each players
	 * 
	 * @param noPlayers
	 */
	public void dealInitialCards(int noPlayers) {
		logger.info("Players are given 2 cards each...");
		for (Player player : players) {
			for (int j = 0; j < 2; j++) {
				Card card = deck.dealCard();
				player.addCard(card);
				logger.info(player.getName() + " gets card " + card.getRank() + "(" + card.getRank().getValue() + ")");
			}
		}
	}
	
	/*************************PLAY GAME ******************************/
	public void play() {
		List<BlackjackRule> roundResult = new ArrayList<>();
		for (int i = 0; i < players.size(); i++) {
			roundResult.add(playRound(players.get(i)));
		}
		boolean allStick = true;
		for (BlackjackRule result : roundResult) {
			if(!result.equals(BlackjackRule.STICK)) {
				allStick = false;
				break;
			}
		}
		if (allStick) {
			logger.info("All STICK, game ends, nobody wins!");
			System.exit(0);
		}
		if (players.size() == 1) {
			logger.info(players.get(0).getName() + " is the only one left and wins the game!");
			System.exit(0);
		}
		play();
	}
	
	/*************************PLAY ROUND ******************************/
	public BlackjackRule playRound(Player player) {
		logger.info("******************");
		BlackjackRule result = BlackjackRound.play(player);
		switch (result) {
			case HIT:
				Card card = deck.dealCard();
				player.addCard(card);
				logger.info(player.getName() + " HIT - gets another card: " + card.getRank());
				playRound(player);
				break;
			case STICK:
				logger.info(player.getName() + " STICKS - doesn't get more cards");
				break;
			case GO_BUST:
				logger.info(player.getName() + " GO_BUST - bye bye");
				players.remove(player);
				break;
			case WIN:
				logger.info(player.getName() + " HITS 21 and WINNNNS");
				System.exit(0);
		}
		return result;
	}
}
