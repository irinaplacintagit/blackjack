package codingtest.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import codingtest.blackjack.BlackjackGame;
import codingtest.domain.GameType;

@Component
public class GameFactory {
	
	@Autowired 
	private BlackjackGame blackjackGame;
	
	public Game getGame(GameType game) {
		if(GameType.BLACKJACK.equals(game)) {
			return blackjackGame;
		}
		return null;
	}
}
