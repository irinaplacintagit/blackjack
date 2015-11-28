package codingtest.game;

import codingtest.domain.DeckShuffle;

/**
 * @author Irina
 *
 */
public interface Game {
	void playGame(int noPlayers, DeckShuffle shuffleType);
}
