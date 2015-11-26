package codingtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.istack.internal.logging.Logger;

import codingtest.domain.Deck;
import codingtest.domain.Player;
import codingtest.domain.RuleResult;

@Service
public class BlackjackService {
	private static final Logger logger = Logger.getLogger(BlackjackService.class);
	
	private Deck deck;
	private List<Player> players;
	
	/*************************INIT GAME ******************************/
	public void initDeck() {
		deck = new Deck();
		deck.init();
		deck.shuffle();
		logger.info("Shuffling cards ...");
	}
	
	// give 2 cards to each of the players
	public void initPlayers() {
		players = new ArrayList<>();
		logger.info("Players: ");
		for (int i = 0; i < 3; i++) {
			Player player = new Player("Player " + i);
			players.add(player);
			logger.info("[" + i + 1 + "]:" + player.getName());
		}
		logger.info("Players are given 2 cards each...");
		for (int j = 0 ; j < 2; j++) {
			for (Player player : players) {
				player.addCard(deck.dealCard());
			}
		}
	}

	/*************************PLAY A ROUND ******************************/
	public void play() {
		List<RuleResult> roundResult = new ArrayList<>();
		for (Player player: players) {
			roundResult.add(playRound(player));
		}
		boolean allStick = true;
		for (RuleResult result : roundResult) {
			if(!result.equals(RuleResult.STICK)) {
				allStick = false;
				break;
			}
		}
		if (allStick) {
			logger.info("All STICK, game ends, nobody wins!");
		}
		if (players.size() == 1) {
			logger.info(players.get(0).getName() + " is the only one left and wins the game!");
		}
	}
	
	public RuleResult playRound(Player player) {
		logger.info("Round: ");
		RuleResult result = GameRound.play(player);
		switch (result) {
			case HIT:
				player.addCard(deck.dealCard());
				logger.info(player.getName() + " HIT - gets another card");
				playRound(player);
				break;
			case STICK:
				logger.info(player.getName() + " STICKS - doesn't get more cards");
				break;
			case GO_BUST:
				logger.info(player.getName() + " GO_BUST - bye bye");
				players.remove(player);
			case WIN:
				logger.info(player.getName() + " HITS 21 and WINNNNS");
				System.exit(0);
		}
		return result;
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
