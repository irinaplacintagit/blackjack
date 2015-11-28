package codingtest.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import codingtest.domain.DeckShuffle;
import codingtest.game.Game;

/**
 * @author Irina
 * 
 * Blackjack game steps taken 
 */
@Component
public class BlackjackGame implements Game{
	
	@Autowired
	private BlackjackService blackjackService;
	
	/**
	 * Steps in blackjack:
	 * - initialise deck
	 * - initialise players
	 * - give players 2 cards each
	 * - play 
	 */
	public void playGame(int noPlayers, DeckShuffle shuffleType) {
		blackjackService.initDeck(shuffleType);
		blackjackService.initPlayers(noPlayers);
		blackjackService.dealInitialCards(noPlayers);
		blackjackService.play();
	}	
}
