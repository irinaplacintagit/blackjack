package codingtest.game;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import codingtest.domain.Deck;
import codingtest.domain.DeckShuffle;
import codingtest.domain.Player;

/**
 * @author Irina
 *
 * Contains basic operations for a cards games
 * - initialise deck
 * - initialise players
 */
public abstract class GameService {
	private static final Logger logger = LogManager.getLogger(GameService.class);
	
	protected Deck deck;
	protected List<Player> players;
	
	/*************************INIT GAME ******************************/
	/**
	 * Initialise deck and shuffle it with the mechanism specified
	 * 
	 * @param shuffle
	 */
	public void initDeck(DeckShuffle shuffle) {
		deck = new Deck();
		deck.init();
		switch (shuffle) {
			case SHUFFLE: deck.shuffle(); break;
			case RIFFLE:
			case PHAROAH_FARO:
			default: deck.shuffle();
		}
		logger.info("Shuffling cards ...");
	}
	
	/**
	 * Add players to the game
	 * 
	 * @param noPlayers
	 */
	public void initPlayers(int noPlayers) {
		players = new ArrayList<>();
		logger.info("We have the following players: ");
		for (int i = 0; i < noPlayers; i++) {
			Player player = new Player("Player " + i);
			players.add(player);
			logger.info(player.getName());
		}
	}
	
	/*******************************************************/
	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
