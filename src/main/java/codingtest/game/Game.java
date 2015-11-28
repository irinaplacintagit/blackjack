package codingtest.game;

import codingtest.domain.DeckShuffle;

public interface Game {
	void playGame(int noPlayers, DeckShuffle shuffleType);
}
