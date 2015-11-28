package codingtest.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Irina
 *  
 * This is the domain class that represents a player in a card game.
 */
public class Player {
	private String name;
	private List<Card> hand;
	
	public Player(String name) {
		this.name = name;
		hand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		hand.add(card);
	}
	
	public void removeCard(Card card) {
		hand.remove(card);
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}
	
	public int getCardsSum() {
		int sum = 0;
		for (Card card : hand) {
			sum += card.getRank().getValue();
		}
		return sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
