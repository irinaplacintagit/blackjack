package codingtest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.media.jfxmedia.events.PlayerStateListener;

import codingtest.domain.Deck;
import codingtest.domain.Player;
import codingtest.domain.RuleResult;

@Service
public class BlackjackService {
	private Deck deck;
	private List<Player> players;
	
	public void initDeck() {
		deck = new Deck();
		deck.init();
		deck.shuffle();
	}
	
	// give 2 cards to each of the players
	public void initPlayers() {
		players = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Player playerHand = new Player("Player " + i);
			players.add(playerHand);
		}
		for (int j = 0 ; j < 2; j++) {
			for (Player player : players) {
				player.addCard(deck.dealCard());
			}
		}
	}

	public void playRound(Player player) {
		RuleResult result = RoundRule.play(player);
		switch (result) {
			case HIT:
				player.addCard(deck.dealCard());
				playRound(player);
				break;
			case STICK:
				break;
			case GO_BUST:
				players.remove(player);
			case WIN:
				System.out.println("Player " + player.getName() + " won!!!");
				System.exit(0);
		}
	}
	
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
