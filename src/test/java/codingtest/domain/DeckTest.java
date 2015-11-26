package codingtest.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

private Deck deck;
	
	@Before
	public void setUp() {
		deck = new Deck();
	}

	@Test
	public void testInitDeck() {
		deck.init();
		assertEquals(52, deck.getDeck().size());
		assertTrue(deck.getDeck().contains(new Card(Suit.CLUB, Rank.TWO)));
		assertTrue(deck.getDeck().contains(new Card(Suit.DIAMOND, Rank.TWO)));
		assertTrue(deck.getDeck().contains(new Card(Suit.HEART, Rank.TWO)));
		assertTrue(deck.getDeck().contains(new Card(Suit.SPADE, Rank.TWO)));
		assertTrue(deck.getDeck().contains(new Card(Suit.CLUB, Rank.ACE)));
		assertTrue(deck.getDeck().contains(new Card(Suit.DIAMOND, Rank.ACE)));
		assertTrue(deck.getDeck().contains(new Card(Suit.HEART, Rank.ACE)));
		assertTrue(deck.getDeck().contains(new Card(Suit.SPADE, Rank.ACE)));

	}

	@Test
	public void testShuffle() {
		deck.init();
		deck.shuffle();
		assertTrue(!(new Card(Suit.HEART, Rank.TWO)).equals(deck.getDeck().poll())
					&& !(new Card(Suit.DIAMOND, Rank.TWO)).equals(deck.getDeck().poll()) 
					&& !(new Card(Suit.CLUB, Rank.TWO)).equals(deck.getDeck().poll()));
	}
	
	@Test
	public void testDealCard() {
		deck.init();
		Card card = deck.dealCard();
		assertEquals(new Card(Suit.HEART, Rank.TWO), card);
		assertEquals(51, deck.getDeck().size());
	}

}
