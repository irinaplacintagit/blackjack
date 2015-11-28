package codingtest.blackjack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import codingtest.blackjack.BlackjackRound;
import codingtest.domain.Card;
import codingtest.domain.Player;
import codingtest.domain.Rank;
import codingtest.domain.BlackjackRule;
import codingtest.domain.Suit;

public class BlackjackRoundTest {

	@Test
	public void testPlayHIT() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		assertEquals(BlackjackRule.HIT, BlackjackRound.play(player));
	}
	
	@Test
	public void testPlaySTICK() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.NINE));
		assertEquals(BlackjackRule.STICK, BlackjackRound.play(player));
	}
	
	@Test
	public void testPlayWIN() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.TEN));
		assertEquals(BlackjackRule.WIN, BlackjackRound.play(player));
	}
	
	@Test
	public void testPlayGOBUST() {
		Player player = new Player("Fred Flinstones");
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		player.addCard(new Card(Suit.CLUB, Rank.ACE));
		assertEquals(BlackjackRule.GO_BUST, BlackjackRound.play(player));
	}

}
