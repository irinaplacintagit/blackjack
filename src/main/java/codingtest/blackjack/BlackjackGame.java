package codingtest.blackjack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import codingtest.domain.DeckShuffle;
import codingtest.game.Game;

@Component
public class BlackjackGame implements Game{
	
	@Autowired
	private BlackjackService blackjackService;
	
	public void playGame(int noPlayers, DeckShuffle shuffleType) {
		blackjackService.initDeck(shuffleType);
		blackjackService.initPlayers(noPlayers);
		blackjackService.play();
	}	
}
