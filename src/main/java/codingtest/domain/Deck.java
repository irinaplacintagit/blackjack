package codingtest.domain;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This is the class that represents a deck of cards in a card game.
 */
public class Deck {
	
	private Queue<Card> deck;
	
	public void init() {
		deck = new LinkedList<>();
		for (Rank rank : Rank.values()) {
			for (Suit suit : Suit.values()) {
				Card card = new Card(suit, rank);
				deck.add(card);
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle((List<?>) deck);
	}
	
	public Card dealCard() {
		return deck.poll();
	}

	public Queue<Card> getDeck() {
		return deck;
	}
	
	
}
